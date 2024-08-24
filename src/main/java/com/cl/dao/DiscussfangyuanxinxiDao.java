package com.cl.dao;

import com.cl.entity.DiscussfangyuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangyuanxinxiView;


/**
 * 房源信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-02 22:21:07
 */
public interface DiscussfangyuanxinxiDao extends BaseMapper<DiscussfangyuanxinxiEntity> {
	
	List<DiscussfangyuanxinxiView> selectListView(@Param("ew") Wrapper<DiscussfangyuanxinxiEntity> wrapper);

	List<DiscussfangyuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfangyuanxinxiEntity> wrapper);
	
	DiscussfangyuanxinxiView selectView(@Param("ew") Wrapper<DiscussfangyuanxinxiEntity> wrapper);
	

}
