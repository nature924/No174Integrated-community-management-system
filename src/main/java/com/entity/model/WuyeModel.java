package com.entity.model;

import com.entity.WuyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物业人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuyeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 物业人员姓名
     */
    private String wuyeName;


    /**
     * 物业人员手机号
     */
    private String wuyePhone;


    /**
     * 物业人员身份证号
     */
    private String wuyeIdNumber;


    /**
     * 物业人员头像
     */
    private String wuyePhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 人员类型
     */
    private Integer wuyeTypes;


    /**
     * 物业人员邮箱
     */
    private String wuyeEmail;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：物业人员姓名
	 */
    public String getWuyeName() {
        return wuyeName;
    }


    /**
	 * 设置：物业人员姓名
	 */
    public void setWuyeName(String wuyeName) {
        this.wuyeName = wuyeName;
    }
    /**
	 * 获取：物业人员手机号
	 */
    public String getWuyePhone() {
        return wuyePhone;
    }


    /**
	 * 设置：物业人员手机号
	 */
    public void setWuyePhone(String wuyePhone) {
        this.wuyePhone = wuyePhone;
    }
    /**
	 * 获取：物业人员身份证号
	 */
    public String getWuyeIdNumber() {
        return wuyeIdNumber;
    }


    /**
	 * 设置：物业人员身份证号
	 */
    public void setWuyeIdNumber(String wuyeIdNumber) {
        this.wuyeIdNumber = wuyeIdNumber;
    }
    /**
	 * 获取：物业人员头像
	 */
    public String getWuyePhoto() {
        return wuyePhoto;
    }


    /**
	 * 设置：物业人员头像
	 */
    public void setWuyePhoto(String wuyePhoto) {
        this.wuyePhoto = wuyePhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：人员类型
	 */
    public Integer getWuyeTypes() {
        return wuyeTypes;
    }


    /**
	 * 设置：人员类型
	 */
    public void setWuyeTypes(Integer wuyeTypes) {
        this.wuyeTypes = wuyeTypes;
    }
    /**
	 * 获取：物业人员邮箱
	 */
    public String getWuyeEmail() {
        return wuyeEmail;
    }


    /**
	 * 设置：物业人员邮箱
	 */
    public void setWuyeEmail(String wuyeEmail) {
        this.wuyeEmail = wuyeEmail;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
