package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangdongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangdongView;


/**
 * 房东
 *
 * @author 
 * @email 
 * @date 2024-04-02 22:21:06
 */
public interface FangdongService extends IService<FangdongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangdongView> selectListView(Wrapper<FangdongEntity> wrapper);
   	
   	FangdongView selectView(@Param("ew") Wrapper<FangdongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangdongEntity> wrapper);
   	

}

