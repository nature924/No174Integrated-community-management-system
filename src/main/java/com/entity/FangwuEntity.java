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
 * 房屋
 *
 * @author 
 * @email
 */
@TableName("fangwu")
public class FangwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangwuEntity() {

	}

	public FangwuEntity(T t) {
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
     * 房屋楼号
     */
    @ColumnInfo(comment="房屋楼号",type="int(11)")
    @TableField(value = "fangwu_louhao_types")

    private Integer fangwuLouhaoTypes;


    /**
     * 单元号
     */
    @ColumnInfo(comment="单元号",type="int(11)")
    @TableField(value = "fangwu_danyuan_types")

    private Integer fangwuDanyuanTypes;


    /**
     * 房间号
     */
    @ColumnInfo(comment="房间号",type="varchar(200)")
    @TableField(value = "fangwu_fanghao")

    private String fangwuFanghao;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fangwu_delete")

    private Integer fangwuDelete;


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
	 * 获取：房屋楼号
	 */
    public Integer getFangwuLouhaoTypes() {
        return fangwuLouhaoTypes;
    }
    /**
	 * 设置：房屋楼号
	 */

    public void setFangwuLouhaoTypes(Integer fangwuLouhaoTypes) {
        this.fangwuLouhaoTypes = fangwuLouhaoTypes;
    }
    /**
	 * 获取：单元号
	 */
    public Integer getFangwuDanyuanTypes() {
        return fangwuDanyuanTypes;
    }
    /**
	 * 设置：单元号
	 */

    public void setFangwuDanyuanTypes(Integer fangwuDanyuanTypes) {
        this.fangwuDanyuanTypes = fangwuDanyuanTypes;
    }
    /**
	 * 获取：房间号
	 */
    public String getFangwuFanghao() {
        return fangwuFanghao;
    }
    /**
	 * 设置：房间号
	 */

    public void setFangwuFanghao(String fangwuFanghao) {
        this.fangwuFanghao = fangwuFanghao;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangwuDelete() {
        return fangwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFangwuDelete(Integer fangwuDelete) {
        this.fangwuDelete = fangwuDelete;
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
        return "Fangwu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", fangwuLouhaoTypes=" + fangwuLouhaoTypes +
            ", fangwuDanyuanTypes=" + fangwuDanyuanTypes +
            ", fangwuFanghao=" + fangwuFanghao +
            ", fangwuDelete=" + fangwuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
