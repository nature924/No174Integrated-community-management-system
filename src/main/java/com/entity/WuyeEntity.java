package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 物业人员
 *
 * @author 
 * @email
 */
@TableName("wuye")
public class WuyeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuyeEntity() {

	}

	public WuyeEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 物业人员姓名
     */
    @ColumnInfo(comment="物业人员姓名",type="varchar(200)")
    @TableField(value = "wuye_name")

    private String wuyeName;


    /**
     * 物业人员手机号
     */
    @ColumnInfo(comment="物业人员手机号",type="varchar(200)")
    @TableField(value = "wuye_phone")

    private String wuyePhone;


    /**
     * 物业人员身份证号
     */
    @ColumnInfo(comment="物业人员身份证号",type="varchar(200)")
    @TableField(value = "wuye_id_number")

    private String wuyeIdNumber;


    /**
     * 物业人员头像
     */
    @ColumnInfo(comment="物业人员头像",type="varchar(200)")
    @TableField(value = "wuye_photo")

    private String wuyePhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 人员类型
     */
    @ColumnInfo(comment="人员类型",type="int(11)")
    @TableField(value = "wuye_types")

    private Integer wuyeTypes;


    /**
     * 物业人员邮箱
     */
    @ColumnInfo(comment="物业人员邮箱",type="varchar(200)")
    @TableField(value = "wuye_email")

    private String wuyeEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Wuye{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", wuyeName=" + wuyeName +
            ", wuyePhone=" + wuyePhone +
            ", wuyeIdNumber=" + wuyeIdNumber +
            ", wuyePhoto=" + wuyePhoto +
            ", sexTypes=" + sexTypes +
            ", wuyeTypes=" + wuyeTypes +
            ", wuyeEmail=" + wuyeEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
