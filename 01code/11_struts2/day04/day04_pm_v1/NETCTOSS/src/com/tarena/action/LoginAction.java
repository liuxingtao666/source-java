package com.tarena.action;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.ILoginDao;
import com.tarena.entity.Admin;

/**
 *	��¼У��Action
 */
public class LoginAction {

	//input
	private String adminCode;//�˺�
	private String password;//����
	//output
	private String errorMsg;//��ʾ��Ϣ
	
	public String execute() {
		ILoginDao dao = 
			DaoFactory.getLoginDao();
		//��ѯ����Ա
		Admin admin = null;
		try {
			admin = dao.findByCode(adminCode);
		} catch (DaoException e) {
			e.printStackTrace();
			//�����ˣ���ת������ҳ��
			return "error";
		}
		//У���˺�
		if(admin == null) {
			//�˺Ų�����
			errorMsg = "�˺Ų�����.";
			//ʧ���ˣ���ת�ص�¼ҳ��
			return "fail";
		} else {
			//�˺���ȷ����У������
			if(!admin.getPassword().equals(password)) {
				//���벻һ��
				errorMsg = "�������.";
				// ʧ���ˣ���ת�ص�¼ҳ��
				return "fail";
			}
		}
		
		//���У��δʧ�ܣ����¼�ɹ�
		return "success";
	}
	
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
