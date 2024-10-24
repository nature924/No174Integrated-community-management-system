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
 * 出入
 *
 * @author 
 * @email
 */
@TableName("churu")
public class ChuruEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuruEntity() {

	}

	public ChuruEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 出入名称
     */
    @ColumnInfo(comment="出入名称",type="varchar(200)")
    @TableField(value = "churu_name")

    private String churuName;


    /**
     * 出入类型
     */
    @ColumnInfo(comment="出入类型",type="int(11)")
    @TableField(value = "churu_types")

    private Integer churuTypes;


    /**
     * 出入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="出入时间",type="timestamp")
    @TableField(value = "churu_time")

    private Date churuTime;


    /**
     * 出入介绍
     */
    @ColumnInfo(comment="出入介绍",type="text")
    @TableField(value = "churu_content")

    private String churuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "churu_delete")

    private Integer churuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：出入名称
	 */
    public String getChuruName() {
        return churuName;
    }
    /**
	 * 设置：出入名称
	 */

    public void setChuruName(String churuName) {
        this.churuName = churuName;
    }
    /**
	 * 获取：出入类型
	 */
    public Integer getChuruTypes() {
        return churuTypes;
    }
    /**
	 * 设置：出入类型
	 */

    public void setChuruTypes(Integer churuTypes) {
        this.churuTypes = churuTypes;
    }
    /**
	 * 获取：出入时间
	 */
    public Date getChuruTime() {
        return churuTime;
    }
    /**
	 * 设置：出入时间
	 */

    public void setChuruTime(Date churuTime) {
        this.churuTime = churuTime;
    }
    /**
	 * 获取：出入介绍
	 */
    public String getChuruContent() {
        return churuContent;
    }
    /**
	 * 设置：出入介绍
	 */

    public void setChuruContent(String churuContent) {
        this.churuContent = churuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChuruDelete() {
        return churuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChuruDelete(Integer churuDelete) {
        this.churuDelete = churuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Churu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", churuName=" + churuName +
            ", churuTypes=" + churuTypes +
            ", churuTime=" + DateUtil.convertString(churuTime,"yyyy-MM-dd") +
            ", churuContent=" + churuContent +
            ", churuDelete=" + churuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
