package com.tarena.action.cost;

import java.util.HashMap;
import java.util.Map;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.cost.ICostDao;
import com.tarena.entity.Cost;

/**
 *	У���ʷ����Ƿ��ظ�
 */
public class CheckCostNameAction {

	//input
	private String name;//�ʷ�����
	//output
	private Map<String, Object> info = 
		new HashMap<String, Object>();
	
	public String execute() {
		ICostDao dao = 
			DaoFactory.getCostDao();
		try {
			// ��ѯ�ʷ�����
			Cost cost = dao.findByName(name);
			// У���ʷ����Ƿ��ظ�
			if(cost == null) {
				//û�ظ���У��ͨ��
				info.put("success", true);
				info.put("message", "��Ч���ʷ���.");
			} else {
				//�ظ��ˣ�У��ʧ��
				info.put("success", false);
				info.put("message", "�ʷ����ظ�.");
			}
		} catch (DaoException e) {
			e.printStackTrace();
			/*
			 * �첽����ʱ����Ҫת��JSP��
			 * �����첽����Ļص����������
			 * ��ת����JSP�еĴ��룬��������
			 * ������ʵ����ת����
			 * */
			info.put("success", false);//���򱨴�
			info.put("message", "��ѯ�ʷ��������쳣������ϵϵͳ����Ա.");
		}
		return "success";
	}
	
	public Map<String, Object> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
