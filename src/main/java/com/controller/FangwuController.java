
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 房屋
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangwu")
public class FangwuController {
    private static final Logger logger = LoggerFactory.getLogger(FangwuController.class);

    private static final String TABLE_NAME = "fangwu";

    @Autowired
    private FangwuService fangwuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxiuService baoxiuService;//报修
    @Autowired
    private CheweiService cheweiService;//车位
    @Autowired
    private CheweiFenpeiService cheweiFenpeiService;//车位分配
    @Autowired
    private ChuruService churuService;//出入
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FeiyongService feiyongService;//物业费缴纳
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LiuyanService liuyanService;//物业人员投诉
    @Autowired
    private SixinService sixinService;//我的私信
    @Autowired
    private WuyeService wuyeService;//物业人员
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("物业人员".equals(role))
            params.put("wuyeId",request.getSession().getAttribute("userId"));
        params.put("fangwuDeleteStart",1);params.put("fangwuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = fangwuService.queryPage(params);

        //字典表数据转换
        List<FangwuView> list =(List<FangwuView>)page.getList();
        for(FangwuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangwuEntity fangwu = fangwuService.selectById(id);
        if(fangwu !=null){
            //entity转view
            FangwuView view = new FangwuView();
            BeanUtils.copyProperties( fangwu , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(fangwu.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangwuEntity fangwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangwu:{}",this.getClass().getName(),fangwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            fangwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FangwuEntity> queryWrapper = new EntityWrapper<FangwuEntity>()
            .eq("yonghu_id", fangwu.getYonghuId())
            .eq("fangwu_louhao_types", fangwu.getFangwuLouhaoTypes())
            .eq("fangwu_danyuan_types", fangwu.getFangwuDanyuanTypes())
            .eq("fangwu_fanghao", fangwu.getFangwuFanghao())
            .eq("fangwu_delete", fangwu.getFangwuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangwuEntity fangwuEntity = fangwuService.selectOne(queryWrapper);
        if(fangwuEntity==null){
            fangwu.setFangwuDelete(1);
            fangwu.setInsertTime(new Date());
            fangwu.setCreateTime(new Date());
            fangwuService.insert(fangwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangwuEntity fangwu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fangwu:{}",this.getClass().getName(),fangwu.toString());
        FangwuEntity oldFangwuEntity = fangwuService.selectById(fangwu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            fangwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            fangwuService.updateById(fangwu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FangwuEntity> oldFangwuList =fangwuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<FangwuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FangwuEntity fangwuEntity = new FangwuEntity();
            fangwuEntity.setId(id);
            fangwuEntity.setFangwuDelete(2);
            list.add(fangwuEntity);
        }
        if(list != null && list.size() >0){
            fangwuService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FangwuEntity> fangwuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FangwuEntity fangwuEntity = new FangwuEntity();
//                            fangwuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fangwuEntity.setFangwuLouhaoTypes(Integer.valueOf(data.get(0)));   //房屋楼号 要改的
//                            fangwuEntity.setFangwuDanyuanTypes(Integer.valueOf(data.get(0)));   //单元号 要改的
//                            fangwuEntity.setFangwuFanghao(data.get(0));                    //房间号 要改的
//                            fangwuEntity.setFangwuDelete(1);//逻辑删除字段
//                            fangwuEntity.setInsertTime(date);//时间
//                            fangwuEntity.setCreateTime(date);//时间
                            fangwuList.add(fangwuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fangwuService.insertBatch(fangwuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = fangwuService.queryPage(params);

        //字典表数据转换
        List<FangwuView> list =(List<FangwuView>)page.getList();
        for(FangwuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangwuEntity fangwu = fangwuService.selectById(id);
            if(fangwu !=null){


                //entity转view
                FangwuView view = new FangwuView();
                BeanUtils.copyProperties( fangwu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fangwu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FangwuEntity fangwu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangwu:{}",this.getClass().getName(),fangwu.toString());
        Wrapper<FangwuEntity> queryWrapper = new EntityWrapper<FangwuEntity>()
            .eq("yonghu_id", fangwu.getYonghuId())
            .eq("fangwu_louhao_types", fangwu.getFangwuLouhaoTypes())
            .eq("fangwu_danyuan_types", fangwu.getFangwuDanyuanTypes())
            .eq("fangwu_fanghao", fangwu.getFangwuFanghao())
            .eq("fangwu_delete", fangwu.getFangwuDelete())
//            .notIn("fangwu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangwuEntity fangwuEntity = fangwuService.selectOne(queryWrapper);
        if(fangwuEntity==null){
            fangwu.setFangwuDelete(1);
            fangwu.setInsertTime(new Date());
            fangwu.setCreateTime(new Date());
        fangwuService.insert(fangwu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

