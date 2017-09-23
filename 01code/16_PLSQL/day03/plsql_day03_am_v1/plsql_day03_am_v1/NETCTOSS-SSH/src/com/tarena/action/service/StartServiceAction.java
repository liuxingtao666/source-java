package com.tarena.action.service;

import java.util.HashMap;
import java.util.Map;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;
import com.tarena.dao.service.IServiceDao;
import com.tarena.entity.Account;
import com.tarena.entity.Service;

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
		IServiceDao serdao = 
			DaoFactory.getServiceDao();
		IAccountDao accdao = 
			DaoFactory.getAccountDao();
		try {
			//判断对应账务账号的状态，校验是否可以开通业务账号
			Service service = serdao.findById(id);
			Account acc = accdao.findById(
					service.getAccountId());
			String status = acc.getStatus();
			if(status.equals("1")
					|| status.equals("2")) {
				//账务账号暂停或删除时，不能开通业务账号
				info.put("success", false);
				info.put("message", "账务账号未开通，不能进行此项操作.");
			} else {
				//账务账号开通时，允许开通业务账号
				serdao.start(id);
				//开通成功后，给予提示
				info.put("success", true);
				info.put("message", "开通成功.");
			}
		} catch (DaoException e) {
			e.printStackTrace();
			//报错时给予提示
			info.put("success", false);
			info.put("message", e.getMessage());
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
