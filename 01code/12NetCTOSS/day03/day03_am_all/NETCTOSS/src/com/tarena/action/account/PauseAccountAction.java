package com.tarena.action.account;

import java.util.HashMap;
import java.util.Map;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;

/**
 *	‘›Õ£’ÀŒÒ’À∫≈
 */
public class PauseAccountAction {

	//input
	private int id;
	//output
	private Map<String, Object> info = 
		new HashMap<String, Object>();
	
	public String execute() {
		IAccountDao dao = 
			DaoFactory.getAccountDao();
		try {
			//‘›Õ£’ÀŒÒ’À∫≈
			dao.pause(id);
			//‘›Õ£≥…π¶£¨∏¯”ËÃ· æ
			info.put("success", true);
			info.put("message", "‘›Õ£≥…π¶.");
		} catch (DaoException e) {
			e.printStackTrace();
			//‘›Õ£ ß∞‹£¨∏¯”ËÃ· æ
			info.put("success", false);
			info.put("message", "‘›Õ£ ß∞‹.");
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
