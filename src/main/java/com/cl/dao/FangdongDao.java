package com.cl.dao;

import com.cl.entity.FangdongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangdongView;


/**
 * 房东
 * 
 * @author 
 * @email 
 * @date 2024-04-02 22:21:06
 */
public interface FangdongDao extends BaseMapper<FangdongEntity> {
	
	List<FangdongView> selectListView(@Param("ew") Wrapper<FangdongEntity> wrapper);

	List<FangdongView> selectListView(Pagination page,@Param("ew") Wrapper<FangdongEntity> wrapper);
	
	FangdongView selectView(@Param("ew") Wrapper<FangdongEntity> wrapper);
	

}
