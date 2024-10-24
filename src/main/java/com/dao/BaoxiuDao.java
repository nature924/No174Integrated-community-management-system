package com.dao;

import com.entity.BaoxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BaoxiuView;

/**
 * 报修 Dao 接口
 *
 * @author 
 */
public interface BaoxiuDao extends BaseMapper<BaoxiuEntity> {

   List<BaoxiuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
