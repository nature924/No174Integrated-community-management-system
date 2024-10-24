package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.CheweiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 车位
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chewei")
public class CheweiView extends CheweiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 车位类型的值
	*/
	@ColumnInfo(comment="车位类型的字典表值",type="varchar(200)")
	private String cheweiValue;
	/**
	* 车类状态的值
	*/
	@ColumnInfo(comment="车类状态的字典表值",type="varchar(200)")
	private String cheweiZhuangtaiValue;




	public CheweiView() {

	}

	public CheweiView(CheweiEntity cheweiEntity) {
		try {
			BeanUtils.copyProperties(this, cheweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 车位类型的值
	*/
	public String getCheweiValue() {
		return cheweiValue;
	}
	/**
	* 设置： 车位类型的值
	*/
	public void setCheweiValue(String cheweiValue) {
		this.cheweiValue = cheweiValue;
	}
	//当前表的
	/**
	* 获取： 车类状态的值
	*/
	public String getCheweiZhuangtaiValue() {
		return cheweiZhuangtaiValue;
	}
	/**
	* 设置： 车类状态的值
	*/
	public void setCheweiZhuangtaiValue(String cheweiZhuangtaiValue) {
		this.cheweiZhuangtaiValue = cheweiZhuangtaiValue;
	}




	@Override
	public String toString() {
		return "CheweiView{" +
			", cheweiValue=" + cheweiValue +
			", cheweiZhuangtaiValue=" + cheweiZhuangtaiValue +
			"} " + super.toString();
	}
}
