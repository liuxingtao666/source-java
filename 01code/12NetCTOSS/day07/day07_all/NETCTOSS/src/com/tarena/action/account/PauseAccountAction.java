package com.tarena.action.account;

import java.util.HashMap;
import java.util.Map;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;
import com.tarena.dao.service.IServiceDao;

/**
 *	暂停账务账号
 */
public class PauseAccountAction {

	//input
	private int id;
	//output
	private Map<String, Object> info = 
		new HashMap<String, Object>();
	
	public String execute() {
		IAccountDao accdao = 
			DaoFactory.getAccountDao();
		IServiceDao serdao = 
			DaoFactory.getServiceDao();
		try {
			//暂停账务账号
			accdao.pause(id);
			//暂停该账务账号对应的业务账号
			serdao.pauseByAccount(id);
			//暂停成功，给予提示
			info.put("success", true);
			info.put("message", "暂停成功.");
		} catch (DaoException e) {
			e.printStackTrace();
			//暂停失败，给予提示
			info.put("success", false);
			info.put("message", "暂停失败.");
		}
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
