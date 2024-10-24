package com.dao;

import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwuView;

/**
 * 房屋 Dao 接口
 *
 * @author 
 */
public interface FangwuDao extends BaseMapper<FangwuEntity> {

   List<FangwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
