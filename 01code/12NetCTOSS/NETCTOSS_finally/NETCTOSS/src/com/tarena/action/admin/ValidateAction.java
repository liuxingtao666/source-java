package com.tarena.action.admin;

import java.util.HashMap;
import java.util.Map;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.admin.IAdminDao;
import com.tarena.entity.Admin;

/**
 * ��֤Action������һЩҵ�����֤
 */
public class ValidateAction {

	// input
	private String adminCode; // �˺�

	// output
	private Map<String, Object> info = new HashMap<String, Object>(); // �������

	public String execute() {
		IAdminDao adminDao = DAOFactory.getAdminDAO();
		try {
			Admin admin = adminDao.findByCode(adminCode);
			if (admin == null) {
				//û�ҵ�����Ա�����ظ�
				info.put("isRepeat", false);
				info.put("message", "��Ч�Ĺ���Ա�˺�");
			} else {
				//�ҵ��˹���Ա���ظ���
				info.put("isRepeat", true);
				info.put("message", "����Ա�˺��Ѵ���");
			}
			
			info.put("success", true);
		} catch (DAOException e) {
			e.printStackTrace();
			info.put("success", false);
			info.put("message", "ϵͳ�����쳣������ϵϵͳ����Ա");
		}
		return "success";
	}

	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

}
