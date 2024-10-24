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
 * 物业费缴纳
 *
 * @author 
 * @email
 */
@TableName("feiyong")
public class FeiyongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FeiyongEntity() {

	}

	public FeiyongEntity(T t) {
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
     * 缴费
     */
    @ColumnInfo(comment="缴费",type="varchar(200)")
    @TableField(value = "feiyong_name")

    private String feiyongName;


    /**
     * 缴费类型
     */
    @ColumnInfo(comment="缴费类型",type="int(11)")
    @TableField(value = "feiyong_types")

    private Integer feiyongTypes;


    /**
     * 缴费状态
     */
    @ColumnInfo(comment="缴费状态",type="int(11)")
    @TableField(value = "feiyong_zhuangtai_types")

    private Integer feiyongZhuangtaiTypes;


    /**
     * 年月
     */
    @ColumnInfo(comment="年月",type="varchar(200)")
    @TableField(value = "feiyong_time")

    private String feiyongTime;


    /**
     * 缴费金额
     */
    @ColumnInfo(comment="缴费金额",type="decimal(10,2)")
    @TableField(value = "feiyong_old_money")

    private Double feiyongOldMoney;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "feiyong_delete")

    private Integer feiyongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：缴费
	 */
    public String getFeiyongName() {
        return feiyongName;
    }
    /**
	 * 设置：缴费
	 */

    public void setFeiyongName(String feiyongName) {
        this.feiyongName = feiyongName;
    }
    /**
	 * 获取：缴费类型
	 */
    public Integer getFeiyongTypes() {
        return feiyongTypes;
    }
    /**
	 * 设置：缴费类型
	 */

    public void setFeiyongTypes(Integer feiyongTypes) {
        this.feiyongTypes = feiyongTypes;
    }
    /**
	 * 获取：缴费状态
	 */
    public Integer getFeiyongZhuangtaiTypes() {
        return feiyongZhuangtaiTypes;
    }
    /**
	 * 设置：缴费状态
	 */

    public void setFeiyongZhuangtaiTypes(Integer feiyongZhuangtaiTypes) {
        this.feiyongZhuangtaiTypes = feiyongZhuangtaiTypes;
    }
    /**
	 * 获取：年月
	 */
    public String getFeiyongTime() {
        return feiyongTime;
    }
    /**
	 * 设置：年月
	 */

    public void setFeiyongTime(String feiyongTime) {
        this.feiyongTime = feiyongTime;
    }
    /**
	 * 获取：缴费金额
	 */
    public Double getFeiyongOldMoney() {
        return feiyongOldMoney;
    }
    /**
	 * 设置：缴费金额
	 */

    public void setFeiyongOldMoney(Double feiyongOldMoney) {
        this.feiyongOldMoney = feiyongOldMoney;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFeiyongDelete() {
        return feiyongDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFeiyongDelete(Integer feiyongDelete) {
        this.feiyongDelete = feiyongDelete;
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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Feiyong{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", feiyongName=" + feiyongName +
            ", feiyongTypes=" + feiyongTypes +
            ", feiyongZhuangtaiTypes=" + feiyongZhuangtaiTypes +
            ", feiyongTime=" + feiyongTime +
            ", feiyongOldMoney=" + feiyongOldMoney +
            ", feiyongDelete=" + feiyongDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
