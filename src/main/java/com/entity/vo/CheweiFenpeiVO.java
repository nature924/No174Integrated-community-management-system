package com.entity.vo;

import com.entity.CheweiFenpeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车位分配
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chewei_fenpei")
public class CheweiFenpeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车位
     */

    @TableField(value = "chewei_id")
    private Integer cheweiId;


    /**
     * 住户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fenpei_time")
    private Date fenpeiTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：车位
	 */
    public Integer getCheweiId() {
        return cheweiId;
    }


    /**
	 * 获取：车位
	 */

    public void setCheweiId(Integer cheweiId) {
        this.cheweiId = cheweiId;
    }
    /**
	 * 设置：住户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：住户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：分配时间
	 */
    public Date getFenpeiTime() {
        return fenpeiTime;
    }


    /**
	 * 获取：分配时间
	 */

    public void setFenpeiTime(Date fenpeiTime) {
        this.fenpeiTime = fenpeiTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
