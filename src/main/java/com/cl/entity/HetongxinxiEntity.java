package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 合同信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-02 22:21:07
 */
@TableName("hetongxinxi")
public class HetongxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HetongxinxiEntity() {
		
	}
	
	public HetongxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 房屋名称
	 */
					
	private String fangwumingcheng;
	
	/**
	 * 房屋图片
	 */
					
	private String fangwutupian;
	
	/**
	 * 房屋地址
	 */
					
	private String fangwudizhi;
	
	/**
	 * 合同编号
	 */
					
	private String hetongbianhao;
	
	/**
	 * 合同名称
	 */
					
	private String hetongmingcheng;
	
	/**
	 * 合同文件
	 */
					
	private String hetongwenjian;
	
	/**
	 * 生效日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shengxiaoriqi;
	
	/**
	 * 终止日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date zhongzhiriqi;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 确认时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date querenshijian;
	
	/**
	 * 房东账号
	 */
					
	private String fangdongzhanghao;
	
	/**
	 * 房东姓名
	 */
					
	private String fangdongxingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：房屋名称
	 */
	public void setFangwumingcheng(String fangwumingcheng) {
		this.fangwumingcheng = fangwumingcheng;
	}
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return fangwumingcheng;
	}
	/**
	 * 设置：房屋图片
	 */
	public void setFangwutupian(String fangwutupian) {
		this.fangwutupian = fangwutupian;
	}
	/**
	 * 获取：房屋图片
	 */
	public String getFangwutupian() {
		return fangwutupian;
	}
	/**
	 * 设置：房屋地址
	 */
	public void setFangwudizhi(String fangwudizhi) {
		this.fangwudizhi = fangwudizhi;
	}
	/**
	 * 获取：房屋地址
	 */
	public String getFangwudizhi() {
		return fangwudizhi;
	}
	/**
	 * 设置：合同编号
	 */
	public void setHetongbianhao(String hetongbianhao) {
		this.hetongbianhao = hetongbianhao;
	}
	/**
	 * 获取：合同编号
	 */
	public String getHetongbianhao() {
		return hetongbianhao;
	}
	/**
	 * 设置：合同名称
	 */
	public void setHetongmingcheng(String hetongmingcheng) {
		this.hetongmingcheng = hetongmingcheng;
	}
	/**
	 * 获取：合同名称
	 */
	public String getHetongmingcheng() {
		return hetongmingcheng;
	}
	/**
	 * 设置：合同文件
	 */
	public void setHetongwenjian(String hetongwenjian) {
		this.hetongwenjian = hetongwenjian;
	}
	/**
	 * 获取：合同文件
	 */
	public String getHetongwenjian() {
		return hetongwenjian;
	}
	/**
	 * 设置：生效日期
	 */
	public void setShengxiaoriqi(Date shengxiaoriqi) {
		this.shengxiaoriqi = shengxiaoriqi;
	}
	/**
	 * 获取：生效日期
	 */
	public Date getShengxiaoriqi() {
		return shengxiaoriqi;
	}
	/**
	 * 设置：终止日期
	 */
	public void setZhongzhiriqi(Date zhongzhiriqi) {
		this.zhongzhiriqi = zhongzhiriqi;
	}
	/**
	 * 获取：终止日期
	 */
	public Date getZhongzhiriqi() {
		return zhongzhiriqi;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：确认时间
	 */
	public void setQuerenshijian(Date querenshijian) {
		this.querenshijian = querenshijian;
	}
	/**
	 * 获取：确认时间
	 */
	public Date getQuerenshijian() {
		return querenshijian;
	}
	/**
	 * 设置：房东账号
	 */
	public void setFangdongzhanghao(String fangdongzhanghao) {
		this.fangdongzhanghao = fangdongzhanghao;
	}
	/**
	 * 获取：房东账号
	 */
	public String getFangdongzhanghao() {
		return fangdongzhanghao;
	}
	/**
	 * 设置：房东姓名
	 */
	public void setFangdongxingming(String fangdongxingming) {
		this.fangdongxingming = fangdongxingming;
	}
	/**
	 * 获取：房东姓名
	 */
	public String getFangdongxingming() {
		return fangdongxingming;
	}

}
