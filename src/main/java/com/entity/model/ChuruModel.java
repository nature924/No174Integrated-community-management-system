package com.entity.model;

import com.entity.ChuruEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 出入
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuruModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 出入名称
     */
    private String churuName;


    /**
     * 出入类型
     */
    private Integer churuTypes;


    /**
     * 出入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date churuTime;


    /**
     * 出入介绍
     */
    private String churuContent;


    /**
     * 逻辑删除
     */
    private Integer churuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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

    }
