package com.entity.vo;

import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房屋
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangwu")
public class FangwuVO implements Serializable {
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
     * 房屋楼号
     */

    @TableField(value = "fangwu_louhao_types")
    private Integer fangwuLouhaoTypes;


    /**
     * 单元号
     */

    @TableField(value = "fangwu_danyuan_types")
    private Integer fangwuDanyuanTypes;


    /**
     * 房间号
     */

    @TableField(value = "fangwu_fanghao")
    private String fangwuFanghao;


    /**
     * 逻辑删除
     */

    @TableField(value = "fangwu_delete")
    private Integer fangwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3
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
	 * 设置：房屋楼号
	 */
    public Integer getFangwuLouhaoTypes() {
        return fangwuLouhaoTypes;
    }


    /**
	 * 获取：房屋楼号
	 */

    public void setFangwuLouhaoTypes(Integer fangwuLouhaoTypes) {
        this.fangwuLouhaoTypes = fangwuLouhaoTypes;
    }
    /**
	 * 设置：单元号
	 */
    public Integer getFangwuDanyuanTypes() {
        return fangwuDanyuanTypes;
    }


    /**
	 * 获取：单元号
	 */

    public void setFangwuDanyuanTypes(Integer fangwuDanyuanTypes) {
        this.fangwuDanyuanTypes = fangwuDanyuanTypes;
    }
    /**
	 * 设置：房间号
	 */
    public String getFangwuFanghao() {
        return fangwuFanghao;
    }


    /**
	 * 获取：房间号
	 */

    public void setFangwuFanghao(String fangwuFanghao) {
        this.fangwuFanghao = fangwuFanghao;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFangwuDelete() {
        return fangwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFangwuDelete(Integer fangwuDelete) {
        this.fangwuDelete = fangwuDelete;
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
	 * 设置：创建时间  show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
