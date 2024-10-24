package com.entity.model;

import com.entity.FangwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房屋
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangwuModel implements Serializable {
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
     * 房屋楼号
     */
    private Integer fangwuLouhaoTypes;


    /**
     * 单元号
     */
    private Integer fangwuDanyuanTypes;


    /**
     * 房间号
     */
    private String fangwuFanghao;


    /**
     * 逻辑删除
     */
    private Integer fangwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3
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
	 * 获取：创建时间  show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
