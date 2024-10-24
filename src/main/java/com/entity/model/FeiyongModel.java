package com.entity.model;

import com.entity.FeiyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物业费缴纳
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FeiyongModel implements Serializable {
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
     * 缴费
     */
    private String feiyongName;


    /**
     * 缴费类型
     */
    private Integer feiyongTypes;


    /**
     * 缴费状态
     */
    private Integer feiyongZhuangtaiTypes;


    /**
     * 年月
     */
    private String feiyongTime;


    /**
     * 缴费金额
     */
    private Double feiyongOldMoney;


    /**
     * 逻辑删除
     */
    private Integer feiyongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
