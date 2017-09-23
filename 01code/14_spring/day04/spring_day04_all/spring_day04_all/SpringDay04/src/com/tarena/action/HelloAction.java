package com.tarena.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.MessageDao;

@Controller
@Scope("prototype")
public class HelloAction {
	
	@Resource
	private MessageDao msgDao;
	
	private String msg;
	
	public String sayHello() {
		msg = msgDao.find();
		return "success";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setMsgDao(MessageDao msgDao) {
		this.msgDao = msgDao;
	}

}
