package com.cl.dao;

import com.cl.entity.FangyuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangyuanxinxiView;


/**
 * 房源信息
 * 
 * @author 
 * @email 
 * @date 2024-04-02 22:21:06
 */
public interface FangyuanxinxiDao extends BaseMapper<FangyuanxinxiEntity> {
	
	List<FangyuanxinxiView> selectListView(@Param("ew") Wrapper<FangyuanxinxiEntity> wrapper);

	List<FangyuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuanxinxiEntity> wrapper);
	
	FangyuanxinxiView selectView(@Param("ew") Wrapper<FangyuanxinxiEntity> wrapper);
	

}
