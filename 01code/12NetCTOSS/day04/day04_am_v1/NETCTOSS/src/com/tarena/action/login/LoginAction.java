package com.tarena.action.login;

import com.tarena.action.BaseAction;
import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.login.ILoginDao;
import com.tarena.entity.Admin;

/**
 *	��¼У��Action
 */
public class LoginAction 
	extends BaseAction {

	//input
	private String adminCode;//�˺�
	private String password;//����
	private String verifyCode;//��֤��
	//output
	private String errorMsg;//��ʾ��Ϣ
	
	public String execute() {
		//У����֤��
		String imageCode = (String) 
			session.get("imageCode");
		if(verifyCode == null
				|| !verifyCode.equalsIgnoreCase(imageCode)) {
			errorMsg = "��֤�����.";
			return "fail";
		}
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
		
		//��¼�ɹ�ʱ������¼��Ϣ��¼��session
		/*Map<String, Object> session1 = 
			ActionContext.getContext().getSession();
		HttpSession session2 = 
			ServletActionContext.getRequest().getSession();*/
		session.put("admin", admin);
		
		//���У��δʧ�ܣ����¼�ɹ�
		return "success";
	}
	
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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
