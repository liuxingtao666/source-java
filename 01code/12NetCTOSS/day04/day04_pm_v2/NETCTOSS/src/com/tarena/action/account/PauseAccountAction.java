package com.tarena.action.account;

import java.util.HashMap;
import java.util.Map;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;

/**
 *	��ͣ�����˺�
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
			//��ͣ�����˺�
			dao.pause(id);
			//��ͣ�ɹ���������ʾ
			info.put("success", true);
			info.put("message", "��ͣ�ɹ�.");
		} catch (DaoException e) {
			e.printStackTrace();
			//��ͣʧ�ܣ�������ʾ
			info.put("success", false);
			info.put("message", "��ͣʧ��.");
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
