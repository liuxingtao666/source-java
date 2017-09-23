package com.tarena.action.admin;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.admin.IAdminDao;
import com.tarena.entity.Admin;
import com.tarena.entity.Privilege;
import com.tarena.entity.Role;
import com.tarena.util.PrivilegeReader;

public class FindAdminAction {

	// ��������
	private Integer privilegeId;
	private Integer roleId;
	private int page = 1;
	private int pageSize;
	private int totalPage;

	// �������
	private List<Admin> admins;//�б���ʾ����
	private List<Privilege> privileges;//���ڳ�ʼ����ѯ����"ģ��"
	private List<Role> roles;//���ڳ�ʼ����ѯ����"��ɫ"

	public String execute() {
		IAdminDao dao = DAOFactory.getAdminDAO();
		try {
			admins = dao.findByPage(roleId, privilegeId, page, pageSize);
			totalPage = dao.findTotalPage(roleId, privilegeId, pageSize);
			
			privileges = PrivilegeReader.getPrivileges();
			roles = DAOFactory.getRoleDAO().findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Integer getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
