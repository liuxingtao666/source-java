package com.tarena.action.login;

import com.tarena.action.BaseAction;
import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.login.ILoginDao;
import com.tarena.entity.Admin;

/**
 *	登录校验Action
 */
public class LoginAction 
	extends BaseAction {

	//input
	private String adminCode;//账号
	private String password;//密码
	private String verifyCode;//验证码
	//output
	private String errorMsg;//提示信息
	
	public String execute() {
		//校验验证码
		String imageCode = (String) 
			session.get("imageCode");
		if(verifyCode == null
				|| !verifyCode.equalsIgnoreCase(imageCode)) {
			errorMsg = "验证码错误.";
			return "fail";
		}
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
		
		//登录成功时，将登录信息记录到session
		/*Map<String, Object> session1 = 
			ActionContext.getContext().getSession();
		HttpSession session2 = 
			ServletActionContext.getRequest().getSession();*/
		session.put("admin", admin);
		
		//如果校验未失败，则登录成功
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
