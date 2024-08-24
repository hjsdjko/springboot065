package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangwuzulinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuzulinView;


/**
 * 房屋租赁
 *
 * @author 
 * @email 
 * @date 2024-04-02 22:21:07
 */
public interface FangwuzulinService extends IService<FangwuzulinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwuzulinView> selectListView(Wrapper<FangwuzulinEntity> wrapper);
   	
   	FangwuzulinView selectView(@Param("ew") Wrapper<FangwuzulinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwuzulinEntity> wrapper);
   	

}

