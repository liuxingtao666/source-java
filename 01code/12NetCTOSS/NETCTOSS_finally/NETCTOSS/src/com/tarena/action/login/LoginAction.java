package com.tarena.action.login;

import java.util.List;

import com.tarena.action.BaseAction;
import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Admin;

public class LoginAction extends BaseAction {

	// 输入
	private Admin admin;
	private String imageCode;

	// 输出
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
			//校验验证码
			String code = (String) session.get("imageCode");
			if (code == null || imageCode == null 
					|| !code.equalsIgnoreCase(imageCode)) {
				errorMsg = "请输入正确的验证码！";
				return "fail";
			}
			
			session.put("user", u);
			try {
				//查询登录用户有权限的模块
				List<Integer> privilegeIds = DAOFactory.getAdminDAO()
						.findPrivilegeIdsByAdmin(u.getId());
				session.put("privilegeIds", privilegeIds);
			} catch (DAOException e) {
				e.printStackTrace();
				return "error";
			}
			return "success";
		} else {
			errorMsg = "用户名或密码错误";
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
