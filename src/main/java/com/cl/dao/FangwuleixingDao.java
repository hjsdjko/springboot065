package com.cl.dao;

import com.cl.entity.FangwuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuleixingView;


/**
 * 房屋类型
 * 
 * @author 
 * @email 
 * @date 2024-04-02 22:21:06
 */
public interface FangwuleixingDao extends BaseMapper<FangwuleixingEntity> {
	
	List<FangwuleixingView> selectListView(@Param("ew") Wrapper<FangwuleixingEntity> wrapper);

	List<FangwuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<FangwuleixingEntity> wrapper);
	
	FangwuleixingView selectView(@Param("ew") Wrapper<FangwuleixingEntity> wrapper);
	

}
