package com.tarena.vo;

import com.tarena.entity.Service;

/**
 *	ר�����ڷ�װ��ѯ����ҵ���˺�������ݡ�
 */
public class ServiceVO 
	extends Service {

	//�����˺��ֶ�
	private String idcardNo;
	private String realName;
	//�ʷ��ֶ�
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
