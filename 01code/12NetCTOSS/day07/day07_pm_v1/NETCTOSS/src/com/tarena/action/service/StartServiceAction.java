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
 *	��ͨҵ���˺�
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
			//�ж϶�Ӧ�����˺ŵ�״̬��У���Ƿ���Կ�ͨҵ���˺�
			Service service = serdao.findById(id);
			Account acc = accdao.findById(
					service.getAccountId());
			String status = acc.getStatus();
			if(status.equals("1")
					|| status.equals("2")) {
				//�����˺���ͣ��ɾ��ʱ�����ܿ�ͨҵ���˺�
				info.put("success", false);
				info.put("message", "�����˺�δ��ͨ�����ܽ��д������.");
			} else {
				//�����˺ſ�ͨʱ������ͨҵ���˺�
				serdao.start(id);
				//��ͨ�ɹ��󣬸�����ʾ
				info.put("success", true);
				info.put("message", "��ͨ�ɹ�.");
			}
		} catch (DaoException e) {
			e.printStackTrace();
			//����ʱ������ʾ
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
