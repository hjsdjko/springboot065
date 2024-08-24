package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.annotation.SysLog;

import com.cl.entity.FangwuleixingEntity;
import com.cl.entity.view.FangwuleixingView;

import com.cl.service.FangwuleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房屋类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 22:21:06
 */
@RestController
@RequestMapping("/fangwuleixing")
public class FangwuleixingController {
    @Autowired
    private FangwuleixingService fangwuleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangwuleixingEntity fangwuleixing,
		HttpServletRequest request){
        EntityWrapper<FangwuleixingEntity> ew = new EntityWrapper<FangwuleixingEntity>();

		PageUtils page = fangwuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangwuleixingEntity fangwuleixing, 
		HttpServletRequest request){
        EntityWrapper<FangwuleixingEntity> ew = new EntityWrapper<FangwuleixingEntity>();

		PageUtils page = fangwuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangwuleixingEntity fangwuleixing){
       	EntityWrapper<FangwuleixingEntity> ew = new EntityWrapper<FangwuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangwuleixing, "fangwuleixing")); 
        return R.ok().put("data", fangwuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangwuleixingEntity fangwuleixing){
        EntityWrapper< FangwuleixingEntity> ew = new EntityWrapper< FangwuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangwuleixing, "fangwuleixing")); 
		FangwuleixingView fangwuleixingView =  fangwuleixingService.selectView(ew);
		return R.ok("查询房屋类型成功").put("data", fangwuleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangwuleixingEntity fangwuleixing = fangwuleixingService.selectById(id);
		fangwuleixing = fangwuleixingService.selectView(new EntityWrapper<FangwuleixingEntity>().eq("id", id));
        return R.ok().put("data", fangwuleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangwuleixingEntity fangwuleixing = fangwuleixingService.selectById(id);
		fangwuleixing = fangwuleixingService.selectView(new EntityWrapper<FangwuleixingEntity>().eq("id", id));
        return R.ok().put("data", fangwuleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增房屋类型")
    public R save(@RequestBody FangwuleixingEntity fangwuleixing, HttpServletRequest request){
    	fangwuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangwuleixing);
        fangwuleixingService.insert(fangwuleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增房屋类型")
    @RequestMapping("/add")
    public R add(@RequestBody FangwuleixingEntity fangwuleixing, HttpServletRequest request){
    	fangwuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangwuleixing);
        fangwuleixingService.insert(fangwuleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改房屋类型")
    public R update(@RequestBody FangwuleixingEntity fangwuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuleixing);
        fangwuleixingService.updateById(fangwuleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除房屋类型")
    public R delete(@RequestBody Long[] ids){
        fangwuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
