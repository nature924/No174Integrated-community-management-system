
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
 * 物业费缴纳
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/feiyong")
public class FeiyongController {
    private static final Logger logger = LoggerFactory.getLogger(FeiyongController.class);

    private static final String TABLE_NAME = "feiyong";

    @Autowired
    private FeiyongService feiyongService;


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
    private FangwuService fangwuService;//房屋
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
        params.put("feiyongDeleteStart",1);params.put("feiyongDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = feiyongService.queryPage(params);

        //字典表数据转换
        List<FeiyongView> list =(List<FeiyongView>)page.getList();
        for(FeiyongView c:list){
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
        FeiyongEntity feiyong = feiyongService.selectById(id);
        if(feiyong !=null){
            //entity转view
            FeiyongView view = new FeiyongView();
            BeanUtils.copyProperties( feiyong , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(feiyong.getYonghuId());
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
    public R save(@RequestBody FeiyongEntity feiyong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,feiyong:{}",this.getClass().getName(),feiyong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            feiyong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FeiyongEntity> queryWrapper = new EntityWrapper<FeiyongEntity>()
            .eq("yonghu_id", feiyong.getYonghuId())
            .eq("feiyong_name", feiyong.getFeiyongName())
            .eq("feiyong_types", feiyong.getFeiyongTypes())
            .eq("feiyong_zhuangtai_types", feiyong.getFeiyongZhuangtaiTypes())
            .eq("feiyong_time", feiyong.getFeiyongTime())
            .eq("feiyong_delete", feiyong.getFeiyongDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeiyongEntity feiyongEntity = feiyongService.selectOne(queryWrapper);
        if(feiyongEntity==null){
            feiyong.setFeiyongDelete(1);
            feiyong.setInsertTime(new Date());
            feiyong.setCreateTime(new Date());
            feiyongService.insert(feiyong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FeiyongEntity feiyong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,feiyong:{}",this.getClass().getName(),feiyong.toString());
        FeiyongEntity oldFeiyongEntity = feiyongService.selectById(feiyong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            feiyong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            feiyongService.updateById(feiyong);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FeiyongEntity> oldFeiyongList =feiyongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<FeiyongEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FeiyongEntity feiyongEntity = new FeiyongEntity();
            feiyongEntity.setId(id);
            feiyongEntity.setFeiyongDelete(2);
            list.add(feiyongEntity);
        }
        if(list != null && list.size() >0){
            feiyongService.updateBatchById(list);
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
            List<FeiyongEntity> feiyongList = new ArrayList<>();//上传的东西
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
                            FeiyongEntity feiyongEntity = new FeiyongEntity();
//                            feiyongEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            feiyongEntity.setFeiyongName(data.get(0));                    //缴费 要改的
//                            feiyongEntity.setFeiyongTypes(Integer.valueOf(data.get(0)));   //缴费类型 要改的
//                            feiyongEntity.setFeiyongZhuangtaiTypes(Integer.valueOf(data.get(0)));   //缴费状态 要改的
//                            feiyongEntity.setFeiyongTime(data.get(0));                    //年月 要改的
//                            feiyongEntity.setFeiyongOldMoney(data.get(0));                    //缴费金额 要改的
//                            feiyongEntity.setFeiyongDelete(1);//逻辑删除字段
//                            feiyongEntity.setInsertTime(date);//时间
//                            feiyongEntity.setCreateTime(date);//时间
                            feiyongList.add(feiyongEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        feiyongService.insertBatch(feiyongList);
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
        PageUtils page = feiyongService.queryPage(params);

        //字典表数据转换
        List<FeiyongView> list =(List<FeiyongView>)page.getList();
        for(FeiyongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FeiyongEntity feiyong = feiyongService.selectById(id);
            if(feiyong !=null){


                //entity转view
                FeiyongView view = new FeiyongView();
                BeanUtils.copyProperties( feiyong , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(feiyong.getYonghuId());
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
    public R add(@RequestBody FeiyongEntity feiyong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,feiyong:{}",this.getClass().getName(),feiyong.toString());
        Wrapper<FeiyongEntity> queryWrapper = new EntityWrapper<FeiyongEntity>()
            .eq("yonghu_id", feiyong.getYonghuId())
            .eq("feiyong_name", feiyong.getFeiyongName())
            .eq("feiyong_types", feiyong.getFeiyongTypes())
            .eq("feiyong_zhuangtai_types", feiyong.getFeiyongZhuangtaiTypes())
            .eq("feiyong_time", feiyong.getFeiyongTime())
            .eq("feiyong_delete", feiyong.getFeiyongDelete())
//            .notIn("feiyong_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeiyongEntity feiyongEntity = feiyongService.selectOne(queryWrapper);
        if(feiyongEntity==null){
            feiyong.setFeiyongDelete(1);
            feiyong.setInsertTime(new Date());
            feiyong.setCreateTime(new Date());
        feiyongService.insert(feiyong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

