package com.tarena.action.role;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.role.IRoleDao;
import com.tarena.entity.Role;

/**
 *	ÐÂÔö½ÇÉ«
 */
@Controller
@Scope("prototype")
public class AddRoleAction {
	
	@Resource
	private IRoleDao roleDao;

	//input
	private Role role;

	public String execute() {
		try {
			roleDao.add(role);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
