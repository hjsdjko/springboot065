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


import com.cl.dao.FangwuleixingDao;
import com.cl.entity.FangwuleixingEntity;
import com.cl.service.FangwuleixingService;
import com.cl.entity.view.FangwuleixingView;

@Service("fangwuleixingService")
public class FangwuleixingServiceImpl extends ServiceImpl<FangwuleixingDao, FangwuleixingEntity> implements FangwuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwuleixingEntity> page = this.selectPage(
                new Query<FangwuleixingEntity>(params).getPage(),
                new EntityWrapper<FangwuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangwuleixingEntity> wrapper) {
		  Page<FangwuleixingView> page =new Query<FangwuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FangwuleixingView> selectListView(Wrapper<FangwuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwuleixingView selectView(Wrapper<FangwuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
