package com.dao;

import com.entity.WuyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuyeView;

/**
 * 物业人员 Dao 接口
 *
 * @author 
 */
public interface WuyeDao extends BaseMapper<WuyeEntity> {

   List<WuyeView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
