
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
 * 物业人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuye")
public class WuyeController {
    private static final Logger logger = LoggerFactory.getLogger(WuyeController.class);

    private static final String TABLE_NAME = "wuye";

    @Autowired
    private WuyeService wuyeService;


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
    private FeiyongService feiyongService;//物业费缴纳
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LiuyanService liuyanService;//物业人员投诉
    @Autowired
    private SixinService sixinService;//我的私信
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
        CommonUtil.checkMap(params);
        PageUtils page = wuyeService.queryPage(params);

        //字典表数据转换
        List<WuyeView> list =(List<WuyeView>)page.getList();
        for(WuyeView c:list){
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
        WuyeEntity wuye = wuyeService.selectById(id);
        if(wuye !=null){
            //entity转view
            WuyeView view = new WuyeView();
            BeanUtils.copyProperties( wuye , view );//把实体数据重构到view中
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
    public R save(@RequestBody WuyeEntity wuye, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuye:{}",this.getClass().getName(),wuye.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WuyeEntity> queryWrapper = new EntityWrapper<WuyeEntity>()
            .eq("username", wuye.getUsername())
            .or()
            .eq("wuye_phone", wuye.getWuyePhone())
            .or()
            .eq("wuye_id_number", wuye.getWuyeIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuyeEntity wuyeEntity = wuyeService.selectOne(queryWrapper);
        if(wuyeEntity==null){
            wuye.setCreateTime(new Date());
            wuye.setPassword("123456");
            wuyeService.insert(wuye);
            return R.ok();
        }else {
            return R.error(511,"账户或者物业人员手机号或者物业人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuyeEntity wuye, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wuye:{}",this.getClass().getName(),wuye.toString());
        WuyeEntity oldWuyeEntity = wuyeService.selectById(wuye.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(wuye.getWuyePhoto()) || "null".equals(wuye.getWuyePhoto())){
                wuye.setWuyePhoto(null);
        }

            wuyeService.updateById(wuye);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WuyeEntity> oldWuyeList =wuyeService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wuyeService.deleteBatchIds(Arrays.asList(ids));

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
            List<WuyeEntity> wuyeList = new ArrayList<>();//上传的东西
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
                            WuyeEntity wuyeEntity = new WuyeEntity();
//                            wuyeEntity.setUsername(data.get(0));                    //账户 要改的
//                            //wuyeEntity.setPassword("123456");//密码
//                            wuyeEntity.setWuyeName(data.get(0));                    //物业人员姓名 要改的
//                            wuyeEntity.setWuyePhone(data.get(0));                    //物业人员手机号 要改的
//                            wuyeEntity.setWuyeIdNumber(data.get(0));                    //物业人员身份证号 要改的
//                            wuyeEntity.setWuyePhoto("");//详情和图片
//                            wuyeEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            wuyeEntity.setWuyeTypes(Integer.valueOf(data.get(0)));   //人员类型 要改的
//                            wuyeEntity.setWuyeEmail(data.get(0));                    //物业人员邮箱 要改的
//                            wuyeEntity.setCreateTime(date);//时间
                            wuyeList.add(wuyeEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //物业人员手机号
                                if(seachFields.containsKey("wuyePhone")){
                                    List<String> wuyePhone = seachFields.get("wuyePhone");
                                    wuyePhone.add(data.get(0));//要改的
                                }else{
                                    List<String> wuyePhone = new ArrayList<>();
                                    wuyePhone.add(data.get(0));//要改的
                                    seachFields.put("wuyePhone",wuyePhone);
                                }
                                //物业人员身份证号
                                if(seachFields.containsKey("wuyeIdNumber")){
                                    List<String> wuyeIdNumber = seachFields.get("wuyeIdNumber");
                                    wuyeIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wuyeIdNumber = new ArrayList<>();
                                    wuyeIdNumber.add(data.get(0));//要改的
                                    seachFields.put("wuyeIdNumber",wuyeIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<WuyeEntity> wuyeEntities_username = wuyeService.selectList(new EntityWrapper<WuyeEntity>().in("username", seachFields.get("username")));
                        if(wuyeEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuyeEntity s:wuyeEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //物业人员手机号
                        List<WuyeEntity> wuyeEntities_wuyePhone = wuyeService.selectList(new EntityWrapper<WuyeEntity>().in("wuye_phone", seachFields.get("wuyePhone")));
                        if(wuyeEntities_wuyePhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuyeEntity s:wuyeEntities_wuyePhone){
                                repeatFields.add(s.getWuyePhone());
                            }
                            return R.error(511,"数据库的该表中的 [物业人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //物业人员身份证号
                        List<WuyeEntity> wuyeEntities_wuyeIdNumber = wuyeService.selectList(new EntityWrapper<WuyeEntity>().in("wuye_id_number", seachFields.get("wuyeIdNumber")));
                        if(wuyeEntities_wuyeIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuyeEntity s:wuyeEntities_wuyeIdNumber){
                                repeatFields.add(s.getWuyeIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [物业人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wuyeService.insertBatch(wuyeList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        WuyeEntity wuye = wuyeService.selectOne(new EntityWrapper<WuyeEntity>().eq("username", username));
        if(wuye==null || !wuye.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(wuye.getId(),username, "wuye", "物业人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","物业人员");
        r.put("username",wuye.getWuyeName());
        r.put("tableName","wuye");
        r.put("userId",wuye.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody WuyeEntity wuye, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<WuyeEntity> queryWrapper = new EntityWrapper<WuyeEntity>()
            .eq("username", wuye.getUsername())
            .or()
            .eq("wuye_phone", wuye.getWuyePhone())
            .or()
            .eq("wuye_id_number", wuye.getWuyeIdNumber())
            ;
        WuyeEntity wuyeEntity = wuyeService.selectOne(queryWrapper);
        if(wuyeEntity != null)
            return R.error("账户或者物业人员手机号或者物业人员身份证号已经被使用");
        wuye.setCreateTime(new Date());
        wuyeService.insert(wuye);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        WuyeEntity wuye = wuyeService.selectById(id);
        wuye.setPassword("123456");
        wuyeService.updateById(wuye);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        WuyeEntity wuye = wuyeService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(wuye.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(wuye.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        wuye.setPassword(newPassword);
		wuyeService.updateById(wuye);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        WuyeEntity wuye = wuyeService.selectOne(new EntityWrapper<WuyeEntity>().eq("username", username));
        if(wuye!=null){
            wuye.setPassword("123456");
            wuyeService.updateById(wuye);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrWuye(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        WuyeEntity wuye = wuyeService.selectById(id);
        if(wuye !=null){
            //entity转view
            WuyeView view = new WuyeView();
            BeanUtils.copyProperties( wuye , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wuyeService.queryPage(params);

        //字典表数据转换
        List<WuyeView> list =(List<WuyeView>)page.getList();
        for(WuyeView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuyeEntity wuye = wuyeService.selectById(id);
            if(wuye !=null){


                //entity转view
                WuyeView view = new WuyeView();
                BeanUtils.copyProperties( wuye , view );//把实体数据重构到view中

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
    public R add(@RequestBody WuyeEntity wuye, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wuye:{}",this.getClass().getName(),wuye.toString());
        Wrapper<WuyeEntity> queryWrapper = new EntityWrapper<WuyeEntity>()
            .eq("username", wuye.getUsername())
            .or()
            .eq("wuye_phone", wuye.getWuyePhone())
            .or()
            .eq("wuye_id_number", wuye.getWuyeIdNumber())
//            .notIn("wuye_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuyeEntity wuyeEntity = wuyeService.selectOne(queryWrapper);
        if(wuyeEntity==null){
            wuye.setCreateTime(new Date());
            wuye.setPassword("123456");
        wuyeService.insert(wuye);

            return R.ok();
        }else {
            return R.error(511,"账户或者物业人员手机号或者物业人员身份证号已经被使用");
        }
    }

}

