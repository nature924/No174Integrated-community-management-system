package com.entity.vo;

import com.entity.ChuruEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 出入
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("churu")
public class ChuruVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 出入名称
     */

    @TableField(value = "churu_name")
    private String churuName;


    /**
     * 出入类型
     */

    @TableField(value = "churu_types")
    private Integer churuTypes;


    /**
     * 出入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "churu_time")
    private Date churuTime;


    /**
     * 出入介绍
     */

    @TableField(value = "churu_content")
    private String churuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "churu_delete")
    private Integer churuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：出入名称
	 */
    public String getChuruName() {
        return churuName;
    }


    /**
	 * 获取：出入名称
	 */

    public void setChuruName(String churuName) {
        this.churuName = churuName;
    }
    /**
	 * 设置：出入类型
	 */
    public Integer getChuruTypes() {
        return churuTypes;
    }


    /**
	 * 获取：出入类型
	 */

    public void setChuruTypes(Integer churuTypes) {
        this.churuTypes = churuTypes;
    }
    /**
	 * 设置：出入时间
	 */
    public Date getChuruTime() {
        return churuTime;
    }


    /**
	 * 获取：出入时间
	 */

    public void setChuruTime(Date churuTime) {
        this.churuTime = churuTime;
    }
    /**
	 * 设置：出入介绍
	 */
    public String getChuruContent() {
        return churuContent;
    }


    /**
	 * 获取：出入介绍
	 */

    public void setChuruContent(String churuContent) {
        this.churuContent = churuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChuruDelete() {
        return churuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChuruDelete(Integer churuDelete) {
        this.churuDelete = churuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
