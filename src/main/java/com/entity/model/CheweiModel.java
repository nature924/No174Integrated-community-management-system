package com.entity.model;

import com.entity.CheweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车位
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheweiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车位位置
     */
    private String cheweiName;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 车位类型
     */
    private Integer cheweiTypes;


    /**
     * 车类状态
     */
    private Integer cheweiZhuangtaiTypes;


    /**
     * 车位详情
     */
    private String cheweiXiangqing;


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

    }
