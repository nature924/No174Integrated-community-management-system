package com.entity.vo;

import com.entity.CheweiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车位
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chewei")
public class CheweiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车位位置
     */

    @TableField(value = "chewei_name")
    private String cheweiName;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 车位类型
     */

    @TableField(value = "chewei_types")
    private Integer cheweiTypes;


    /**
     * 车类状态
     */

    @TableField(value = "chewei_zhuangtai_types")
    private Integer cheweiZhuangtaiTypes;


    /**
     * 车位详情
     */

    @TableField(value = "chewei_xiangqing")
    private String cheweiXiangqing;


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
	 * 设置：车位位置
	 */
    public String getCheweiName() {
        return cheweiName;
    }


    /**
	 * 获取：车位位置
	 */

    public void setCheweiName(String cheweiName) {
        this.cheweiName = cheweiName;
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
	 * 设置：车位类型
	 */
    public Integer getCheweiTypes() {
        return cheweiTypes;
    }


    /**
	 * 获取：车位类型
	 */

    public void setCheweiTypes(Integer cheweiTypes) {
        this.cheweiTypes = cheweiTypes;
    }
    /**
	 * 设置：车类状态
	 */
    public Integer getCheweiZhuangtaiTypes() {
        return cheweiZhuangtaiTypes;
    }


    /**
	 * 获取：车类状态
	 */

    public void setCheweiZhuangtaiTypes(Integer cheweiZhuangtaiTypes) {
        this.cheweiZhuangtaiTypes = cheweiZhuangtaiTypes;
    }
    /**
	 * 设置：车位详情
	 */
    public String getCheweiXiangqing() {
        return cheweiXiangqing;
    }


    /**
	 * 获取：车位详情
	 */

    public void setCheweiXiangqing(String cheweiXiangqing) {
        this.cheweiXiangqing = cheweiXiangqing;
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
