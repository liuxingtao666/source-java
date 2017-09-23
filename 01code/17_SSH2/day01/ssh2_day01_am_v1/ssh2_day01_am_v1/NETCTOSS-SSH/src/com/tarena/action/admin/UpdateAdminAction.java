package com.tarena.action.admin;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.admin.IAdminDao;
import com.tarena.entity.Admin;

@Controller
@Scope("prototype")
public class UpdateAdminAction {
	
	@Resource
	private IAdminDao adminDao;
	
	//input
	private Admin admin;
	
	public String update() {
		adminDao.update(admin);
		return "success";
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
