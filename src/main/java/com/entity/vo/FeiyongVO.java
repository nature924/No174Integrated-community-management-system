package com.entity.vo;

import com.entity.FeiyongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物业费缴纳
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("feiyong")
public class FeiyongVO implements Serializable {
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
     * 缴费
     */

    @TableField(value = "feiyong_name")
    private String feiyongName;


    /**
     * 缴费类型
     */

    @TableField(value = "feiyong_types")
    private Integer feiyongTypes;


    /**
     * 缴费状态
     */

    @TableField(value = "feiyong_zhuangtai_types")
    private Integer feiyongZhuangtaiTypes;


    /**
     * 年月
     */

    @TableField(value = "feiyong_time")
    private String feiyongTime;


    /**
     * 缴费金额
     */

    @TableField(value = "feiyong_old_money")
    private Double feiyongOldMoney;


    /**
     * 逻辑删除
     */

    @TableField(value = "feiyong_delete")
    private Integer feiyongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：缴费
	 */
    public String getFeiyongName() {
        return feiyongName;
    }


    /**
	 * 获取：缴费
	 */

    public void setFeiyongName(String feiyongName) {
        this.feiyongName = feiyongName;
    }
    /**
	 * 设置：缴费类型
	 */
    public Integer getFeiyongTypes() {
        return feiyongTypes;
    }


    /**
	 * 获取：缴费类型
	 */

    public void setFeiyongTypes(Integer feiyongTypes) {
        this.feiyongTypes = feiyongTypes;
    }
    /**
	 * 设置：缴费状态
	 */
    public Integer getFeiyongZhuangtaiTypes() {
        return feiyongZhuangtaiTypes;
    }


    /**
	 * 获取：缴费状态
	 */

    public void setFeiyongZhuangtaiTypes(Integer feiyongZhuangtaiTypes) {
        this.feiyongZhuangtaiTypes = feiyongZhuangtaiTypes;
    }
    /**
	 * 设置：年月
	 */
    public String getFeiyongTime() {
        return feiyongTime;
    }


    /**
	 * 获取：年月
	 */

    public void setFeiyongTime(String feiyongTime) {
        this.feiyongTime = feiyongTime;
    }
    /**
	 * 设置：缴费金额
	 */
    public Double getFeiyongOldMoney() {
        return feiyongOldMoney;
    }


    /**
	 * 获取：缴费金额
	 */

    public void setFeiyongOldMoney(Double feiyongOldMoney) {
        this.feiyongOldMoney = feiyongOldMoney;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFeiyongDelete() {
        return feiyongDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFeiyongDelete(Integer feiyongDelete) {
        this.feiyongDelete = feiyongDelete;
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
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
