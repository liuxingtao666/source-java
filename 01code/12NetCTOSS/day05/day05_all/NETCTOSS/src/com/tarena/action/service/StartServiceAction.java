package com.tarena.action.service;

import java.util.HashMap;
import java.util.Map;

/**
 *	开通业务账号
 */
public class StartServiceAction {

	//input
	private int id;
	//output
	private Map<String, Object> info = 
		new HashMap<String, Object>();
	
	public String execute() {
		// TODO 同学们自己完成
		return "success";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<String, Object> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	
}
