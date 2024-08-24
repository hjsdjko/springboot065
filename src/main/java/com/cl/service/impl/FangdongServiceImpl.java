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


import com.cl.dao.FangdongDao;
import com.cl.entity.FangdongEntity;
import com.cl.service.FangdongService;
import com.cl.entity.view.FangdongView;

@Service("fangdongService")
public class FangdongServiceImpl extends ServiceImpl<FangdongDao, FangdongEntity> implements FangdongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangdongEntity> page = this.selectPage(
                new Query<FangdongEntity>(params).getPage(),
                new EntityWrapper<FangdongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangdongEntity> wrapper) {
		  Page<FangdongView> page =new Query<FangdongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FangdongView> selectListView(Wrapper<FangdongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangdongView selectView(Wrapper<FangdongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
