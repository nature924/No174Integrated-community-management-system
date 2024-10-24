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
 * 车位
 *
 * @author 
 * @email
 */
@TableName("chewei")
public class CheweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CheweiEntity() {

	}

	public CheweiEntity(T t) {
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
     * 车位位置
     */
    @ColumnInfo(comment="车位位置",type="varchar(200)")
    @TableField(value = "chewei_name")

    private String cheweiName;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 车位类型
     */
    @ColumnInfo(comment="车位类型",type="int(11)")
    @TableField(value = "chewei_types")

    private Integer cheweiTypes;


    /**
     * 车类状态
     */
    @ColumnInfo(comment="车类状态",type="int(11)")
    @TableField(value = "chewei_zhuangtai_types")

    private Integer cheweiZhuangtaiTypes;


    /**
     * 车位详情
     */
    @ColumnInfo(comment="车位详情",type="text")
    @TableField(value = "chewei_xiangqing")

    private String cheweiXiangqing;


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
	 * 获取：车位位置
	 */
    public String getCheweiName() {
        return cheweiName;
    }
    /**
	 * 设置：车位位置
	 */

    public void setCheweiName(String cheweiName) {
        this.cheweiName = cheweiName;
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
	 * 获取：车位类型
	 */
    public Integer getCheweiTypes() {
        return cheweiTypes;
    }
    /**
	 * 设置：车位类型
	 */

    public void setCheweiTypes(Integer cheweiTypes) {
        this.cheweiTypes = cheweiTypes;
    }
    /**
	 * 获取：车类状态
	 */
    public Integer getCheweiZhuangtaiTypes() {
        return cheweiZhuangtaiTypes;
    }
    /**
	 * 设置：车类状态
	 */

    public void setCheweiZhuangtaiTypes(Integer cheweiZhuangtaiTypes) {
        this.cheweiZhuangtaiTypes = cheweiZhuangtaiTypes;
    }
    /**
	 * 获取：车位详情
	 */
    public String getCheweiXiangqing() {
        return cheweiXiangqing;
    }
    /**
	 * 设置：车位详情
	 */

    public void setCheweiXiangqing(String cheweiXiangqing) {
        this.cheweiXiangqing = cheweiXiangqing;
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
        return "Chewei{" +
            ", id=" + id +
            ", cheweiName=" + cheweiName +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", cheweiTypes=" + cheweiTypes +
            ", cheweiZhuangtaiTypes=" + cheweiZhuangtaiTypes +
            ", cheweiXiangqing=" + cheweiXiangqing +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
