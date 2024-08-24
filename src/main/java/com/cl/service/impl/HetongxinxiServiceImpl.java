package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.HetongxinxiDao;
import com.cl.entity.HetongxinxiEntity;
import com.cl.service.HetongxinxiService;
import com.cl.entity.view.HetongxinxiView;

@Service("hetongxinxiService")
public class HetongxinxiServiceImpl extends ServiceImpl<HetongxinxiDao, HetongxinxiEntity> implements HetongxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HetongxinxiEntity> page = this.selectPage(
                new Query<HetongxinxiEntity>(params).getPage(),
                new EntityWrapper<HetongxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HetongxinxiEntity> wrapper) {
		  Page<HetongxinxiView> page =new Query<HetongxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HetongxinxiView> selectListView(Wrapper<HetongxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HetongxinxiView selectView(Wrapper<HetongxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<HetongxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<HetongxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<HetongxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
