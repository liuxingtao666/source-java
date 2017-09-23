package com.tarena.action.login;

import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Admin;

public class LoginAction extends BaseAction {

	// ����
	private Admin admin;
	private String imageCode;

	// ���
	private String errorMsg;

	public String execute() {
		Admin u = null;
		try {
			u = DAOFactory.getLoginDAO().findByCodeAndPassword(
					admin.getAdminCode(), admin.getPassword());
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}

		if (u != null) {
			//У����֤��
			String code = (String) session.get("imageCode");
			if (code == null || imageCode == null 
					|| !code.equalsIgnoreCase(imageCode)) {
				errorMsg = "��������ȷ����֤�룡";
				return "fail";
			}
			
			session.put("user", u);
			try {
				//��ѯ��¼�û���Ȩ�޵�ģ��
				List<Integer> privilegeIds = DAOFactory.getAdminDAO()
						.findPrivilegeIdsByAdmin(u.getId());
				session.put("privilegeIds", privilegeIds);
			} catch (DAOException e) {
				e.printStackTrace();
				return "error";
			}
			return "success";
		} else {
			errorMsg = "�û������������";
			return "fail";
		}

	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

}
