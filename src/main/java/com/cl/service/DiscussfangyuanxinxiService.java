package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussfangyuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangyuanxinxiView;


/**
 * 房源信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-02 22:21:07
 */
public interface DiscussfangyuanxinxiService extends IService<DiscussfangyuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfangyuanxinxiView> selectListView(Wrapper<DiscussfangyuanxinxiEntity> wrapper);
   	
   	DiscussfangyuanxinxiView selectView(@Param("ew") Wrapper<DiscussfangyuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfangyuanxinxiEntity> wrapper);
   	

}

