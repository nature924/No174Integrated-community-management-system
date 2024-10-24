package com.dao;

import com.entity.FeiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FeiyongView;

/**
 * 物业费缴纳 Dao 接口
 *
 * @author 
 */
public interface FeiyongDao extends BaseMapper<FeiyongEntity> {

   List<FeiyongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
