package com.tarena.vo;

import com.tarena.entity.Service;

/**
 *	专门用于封装查询到的业务账号相关数据。
 */
public class ServiceVO 
	extends Service {

	//账务账号字段
	private String idcardNo;
	private String realName;
	//资费字段
	private String costName;
	private String costDescr;
	
	public String getCostDescr() {
		return costDescr;
	}
	public void setCostDescr(String costDescr) {
		this.costDescr = costDescr;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
	
}
