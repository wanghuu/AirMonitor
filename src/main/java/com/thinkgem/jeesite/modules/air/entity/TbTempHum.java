/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.air.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 温湿度Entity
 * @author Frank Wang
 * @version 2017-05-06
 */
public class TbTempHum extends DataEntity<TbTempHum> {
	
	private static final long serialVersionUID = 1L;
	private Float temp;		// 温度
	private Float hum;		// 湿度
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public TbTempHum() {
		super();
	}

	public TbTempHum(String id){
		super(id);
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}
	
	public Float getHum() {
		return hum;
	}

	public void setHum(Float hum) {
		this.hum = hum;
	}
	
	public Date getBeginUpdateDate() {
		return beginUpdateDate;
	}

	public void setBeginUpdateDate(Date beginUpdateDate) {
		this.beginUpdateDate = beginUpdateDate;
	}
	
	public Date getEndUpdateDate() {
		return endUpdateDate;
	}

	public void setEndUpdateDate(Date endUpdateDate) {
		this.endUpdateDate = endUpdateDate;
	}
		
}