package com.tarena.action;

import com.tarena.dao.MessageDao;

public class HelloAction {
	
	private String msg;
	
	public String sayHello() {
		msg = new MessageDao().find();
		return "success";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
