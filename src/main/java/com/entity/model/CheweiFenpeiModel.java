package com.entity.model;

import com.entity.CheweiFenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车位分配
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheweiFenpeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车位
     */
    private Integer cheweiId;


    /**
     * 住户
     */
    private Integer yonghuId;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fenpeiTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
