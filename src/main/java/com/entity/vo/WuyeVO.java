package com.entity.vo;

import com.entity.WuyeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物业人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuye")
public class WuyeVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 物业人员姓名
     */

    @TableField(value = "wuye_name")
    private String wuyeName;


    /**
     * 物业人员手机号
     */

    @TableField(value = "wuye_phone")
    private String wuyePhone;


    /**
     * 物业人员身份证号
     */

    @TableField(value = "wuye_id_number")
    private String wuyeIdNumber;


    /**
     * 物业人员头像
     */

    @TableField(value = "wuye_photo")
    private String wuyePhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 人员类型
     */

    @TableField(value = "wuye_types")
    private Integer wuyeTypes;


    /**
     * 物业人员邮箱
     */

    @TableField(value = "wuye_email")
    private String wuyeEmail;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：物业人员姓名
	 */
    public String getWuyeName() {
        return wuyeName;
    }


    /**
	 * 获取：物业人员姓名
	 */

    public void setWuyeName(String wuyeName) {
        this.wuyeName = wuyeName;
    }
    /**
	 * 设置：物业人员手机号
	 */
    public String getWuyePhone() {
        return wuyePhone;
    }


    /**
	 * 获取：物业人员手机号
	 */

    public void setWuyePhone(String wuyePhone) {
        this.wuyePhone = wuyePhone;
    }
    /**
	 * 设置：物业人员身份证号
	 */
    public String getWuyeIdNumber() {
        return wuyeIdNumber;
    }


    /**
	 * 获取：物业人员身份证号
	 */

    public void setWuyeIdNumber(String wuyeIdNumber) {
        this.wuyeIdNumber = wuyeIdNumber;
    }
    /**
	 * 设置：物业人员头像
	 */
    public String getWuyePhoto() {
        return wuyePhoto;
    }


    /**
	 * 获取：物业人员头像
	 */

    public void setWuyePhoto(String wuyePhoto) {
        this.wuyePhoto = wuyePhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：人员类型
	 */
    public Integer getWuyeTypes() {
        return wuyeTypes;
    }


    /**
	 * 获取：人员类型
	 */

    public void setWuyeTypes(Integer wuyeTypes) {
        this.wuyeTypes = wuyeTypes;
    }
    /**
	 * 设置：物业人员邮箱
	 */
    public String getWuyeEmail() {
        return wuyeEmail;
    }


    /**
	 * 获取：物业人员邮箱
	 */

    public void setWuyeEmail(String wuyeEmail) {
        this.wuyeEmail = wuyeEmail;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
