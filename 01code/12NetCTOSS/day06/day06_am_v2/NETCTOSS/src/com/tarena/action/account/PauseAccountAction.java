package com.tarena.action.account;

import java.util.HashMap;
import java.util.Map;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;
import com.tarena.dao.service.IServiceDao;

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
		IAccountDao accdao = 
			DaoFactory.getAccountDao();
		IServiceDao serdao = 
			DaoFactory.getServiceDao();
		try {
			//��ͣ�����˺�
			accdao.pause(id);
			//��ͣ�������˺Ŷ�Ӧ��ҵ���˺�
			serdao.pauseByAccount(id);
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
