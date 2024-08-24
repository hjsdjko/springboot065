package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangyuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangyuanxinxiView;


/**
 * 房源信息
 *
 * @author 
 * @email 
 * @date 2024-04-02 22:21:06
 */
public interface FangyuanxinxiService extends IService<FangyuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangyuanxinxiView> selectListView(Wrapper<FangyuanxinxiEntity> wrapper);
   	
   	FangyuanxinxiView selectView(@Param("ew") Wrapper<FangyuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangyuanxinxiEntity> wrapper);
   	

}

