package com.tarena.action.role;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.role.IRoleDao;
import com.tarena.entity.Privilege;
import com.tarena.entity.Role;
import com.tarena.util.PrivilegeReader;

/**
 *	���޸�ҳ��
 */
@Controller
@Scope("prototype")
public class ToUpdateRoleAction {
	
	@Resource
	private IRoleDao roleDao;

	//input
	private int id;
	//output
	private Role role;
	private List<Privilege> privileges;
	
	public String execute() {
		//��ѯ��ɫ
		try {
			role = roleDao.findById(id);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		//��ѯģ��
		privileges = PrivilegeReader.getPrivileges();
		
		return "success";
	}
	
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
