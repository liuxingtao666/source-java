package com.tarena.action;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.ILoginDao;
import com.tarena.entity.Admin;

/**
 *	登录校验Action
 */
public class LoginAction {

	//input
	private String adminCode;//账号
	private String password;//密码
	//output
	private String errorMsg;//提示信息
	
	public String execute() {
		ILoginDao dao = 
			DaoFactory.getLoginDao();
		//查询管理员
		Admin admin = null;
		try {
			admin = dao.findByCode(adminCode);
		} catch (DaoException e) {
			e.printStackTrace();
			//报错了，跳转到错误页面
			return "error";
		}
		//校验账号
		if(admin == null) {
			//账号不存在
			errorMsg = "账号不存在.";
			//失败了，跳转回登录页面
			return "fail";
		} else {
			//账号正确，再校验密码
			if(!admin.getPassword().equals(password)) {
				//密码不一致
				errorMsg = "密码错误.";
				// 失败了，跳转回登录页面
				return "fail";
			}
		}
		
		//如果校验未失败，则登录成功
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
