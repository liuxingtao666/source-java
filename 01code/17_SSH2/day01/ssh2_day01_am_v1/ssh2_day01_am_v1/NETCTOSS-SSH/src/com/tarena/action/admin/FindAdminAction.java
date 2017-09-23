package com.tarena.action.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.admin.IAdminDao;
import com.tarena.entity.Admin;

@Controller
@Scope("prototype")
public class FindAdminAction {
	
	@Resource
	private IAdminDao adminDao;
	
	//input
	private Integer privilegeId;
	private String roleName;
	private int page = 1;
	private int pageSize;
	//output
	private List<Admin> admins;
	private int totalPage;
	
	public String load() {
		try {
			admins = adminDao.findByCondition(
					privilegeId, roleName, 
					page, pageSize);
			totalPage = adminDao.findTotalPage(
					privilegeId, roleName, 
					pageSize);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
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

	public Integer getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
