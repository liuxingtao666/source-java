package com.tarena.action.account;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;
import com.tarena.dao.service.IServiceDao;

/**
 *	暂停账务账号
 */
@Controller
@Scope("prototype")
public class PauseAccountAction {
	
	@Resource
	private IAccountDao accDao;

	//input
	private int id;
	//output
	private Map<String, Object> info = 
		new HashMap<String, Object>();
	
	public String execute() {
		IServiceDao serdao = 
			DaoFactory.getServiceDao();
		try {
			//暂停账务账号
			accDao.pause(id);
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
	
	public void setAccDao(IAccountDao accDao) {
		this.accDao = accDao;
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
