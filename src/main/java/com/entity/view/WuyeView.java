package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WuyeEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物业人员
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wuye")
public class WuyeView extends WuyeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;
	/**
	* 人员类型的值
	*/
	@ColumnInfo(comment="人员类型的字典表值",type="varchar(200)")
	private String wuyeValue;




	public WuyeView() {

	}

	public WuyeView(WuyeEntity wuyeEntity) {
		try {
			BeanUtils.copyProperties(this, wuyeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}
	//当前表的
	/**
	* 获取： 人员类型的值
	*/
	public String getWuyeValue() {
		return wuyeValue;
	}
	/**
	* 设置： 人员类型的值
	*/
	public void setWuyeValue(String wuyeValue) {
		this.wuyeValue = wuyeValue;
	}




	@Override
	public String toString() {
		return "WuyeView{" +
			", sexValue=" + sexValue +
			", wuyeValue=" + wuyeValue +
			"} " + super.toString();
	}
}
