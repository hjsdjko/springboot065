package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangwuleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuleixingView;


/**
 * 房屋类型
 *
 * @author 
 * @email 
 * @date 2024-04-02 22:21:06
 */
public interface FangwuleixingService extends IService<FangwuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwuleixingView> selectListView(Wrapper<FangwuleixingEntity> wrapper);
   	
   	FangwuleixingView selectView(@Param("ew") Wrapper<FangwuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwuleixingEntity> wrapper);
   	

}

