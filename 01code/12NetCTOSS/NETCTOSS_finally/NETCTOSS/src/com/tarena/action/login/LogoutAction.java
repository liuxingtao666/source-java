package com.tarena.action.login;

import com.tarena.action.BaseAction;

public class LogoutAction extends BaseAction {

	private boolean pass;

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public String execute() {
		session.put("user", null);
		pass = true;
		return "success";
	}

}
