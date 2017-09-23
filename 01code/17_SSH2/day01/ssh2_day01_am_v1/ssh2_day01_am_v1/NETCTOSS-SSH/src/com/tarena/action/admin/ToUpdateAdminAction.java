package com.tarena.action.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.admin.IAdminDao;
import com.tarena.dao.role.IRoleDao;
import com.tarena.entity.Admin;
import com.tarena.entity.Role;

@Controller
@Scope("prototype")
public class ToUpdateAdminAction {
	
	@Resource
	private IAdminDao adminDao;
	
	@Resource
	private IRoleDao roleDao;

	//input
	private int id;
	//output
	private Admin admin;
	private List<Role> roles;
	
	public String load() {
		try {
			admin = adminDao.findById(id);
			roles = roleDao.findByPage(
				1, Integer.MAX_VALUE);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
