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

import com.cl.entity.FangwuzulinEntity;
import com.cl.entity.view.FangwuzulinView;

import com.cl.service.FangwuzulinService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房屋租赁
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-02 22:21:07
 */
@RestController
@RequestMapping("/fangwuzulin")
public class FangwuzulinController {
    @Autowired
    private FangwuzulinService fangwuzulinService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangwuzulinEntity fangwuzulin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangdong")) {
			fangwuzulin.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			fangwuzulin.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangwuzulinEntity> ew = new EntityWrapper<FangwuzulinEntity>();

		PageUtils page = fangwuzulinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuzulin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangwuzulinEntity fangwuzulin, 
		HttpServletRequest request){
        EntityWrapper<FangwuzulinEntity> ew = new EntityWrapper<FangwuzulinEntity>();

		PageUtils page = fangwuzulinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuzulin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangwuzulinEntity fangwuzulin){
       	EntityWrapper<FangwuzulinEntity> ew = new EntityWrapper<FangwuzulinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangwuzulin, "fangwuzulin")); 
        return R.ok().put("data", fangwuzulinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangwuzulinEntity fangwuzulin){
        EntityWrapper< FangwuzulinEntity> ew = new EntityWrapper< FangwuzulinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangwuzulin, "fangwuzulin")); 
		FangwuzulinView fangwuzulinView =  fangwuzulinService.selectView(ew);
		return R.ok("查询房屋租赁成功").put("data", fangwuzulinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangwuzulinEntity fangwuzulin = fangwuzulinService.selectById(id);
		fangwuzulin = fangwuzulinService.selectView(new EntityWrapper<FangwuzulinEntity>().eq("id", id));
        return R.ok().put("data", fangwuzulin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangwuzulinEntity fangwuzulin = fangwuzulinService.selectById(id);
		fangwuzulin = fangwuzulinService.selectView(new EntityWrapper<FangwuzulinEntity>().eq("id", id));
        return R.ok().put("data", fangwuzulin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增房屋租赁")
    public R save(@RequestBody FangwuzulinEntity fangwuzulin, HttpServletRequest request){
    	fangwuzulin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangwuzulin);
        fangwuzulinService.insert(fangwuzulin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增房屋租赁")
    @RequestMapping("/add")
    public R add(@RequestBody FangwuzulinEntity fangwuzulin, HttpServletRequest request){
    	fangwuzulin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangwuzulin);
        fangwuzulinService.insert(fangwuzulin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改房屋租赁")
    public R update(@RequestBody FangwuzulinEntity fangwuzulin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuzulin);
        fangwuzulinService.updateById(fangwuzulin);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核房屋租赁")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<FangwuzulinEntity> list = new ArrayList<FangwuzulinEntity>();
        for(Long id : ids) {
            FangwuzulinEntity fangwuzulin = fangwuzulinService.selectById(id);
            fangwuzulin.setSfsh(sfsh);
            fangwuzulin.setShhf(shhf);
            list.add(fangwuzulin);
        }
        fangwuzulinService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除房屋租赁")
    public R delete(@RequestBody Long[] ids){
        fangwuzulinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
