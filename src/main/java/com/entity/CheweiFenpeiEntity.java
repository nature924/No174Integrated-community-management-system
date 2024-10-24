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
 * 车位分配
 *
 * @author 
 * @email
 */
@TableName("chewei_fenpei")
public class CheweiFenpeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CheweiFenpeiEntity() {

	}

	public CheweiFenpeiEntity(T t) {
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
     * 车位
     */
    @ColumnInfo(comment="车位",type="int(11)")
    @TableField(value = "chewei_id")

    private Integer cheweiId;


    /**
     * 住户
     */
    @ColumnInfo(comment="住户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="分配时间",type="timestamp")
    @TableField(value = "fenpei_time")

    private Date fenpeiTime;


    /**
     * 创建时间  listShow
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
	 * 获取：车位
	 */
    public Integer getCheweiId() {
        return cheweiId;
    }
    /**
	 * 设置：车位
	 */

    public void setCheweiId(Integer cheweiId) {
        this.cheweiId = cheweiId;
    }
    /**
	 * 获取：住户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：住户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：分配时间
	 */
    public Date getFenpeiTime() {
        return fenpeiTime;
    }
    /**
	 * 设置：分配时间
	 */

    public void setFenpeiTime(Date fenpeiTime) {
        this.fenpeiTime = fenpeiTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CheweiFenpei{" +
            ", id=" + id +
            ", cheweiId=" + cheweiId +
            ", yonghuId=" + yonghuId +
            ", fenpeiTime=" + DateUtil.convertString(fenpeiTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
