package com.tarena.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *	管理员实体类
 */
public class Admin {

	private Integer id;
	private String adminCode;
	private String password;
	private String name;
	private String telephone;
	private String email;
	private Date enrollDate;
	
	/**
	 * 用于封装对应的一组角色
	 */
	private Set<Role> roles;
	
	/**
	 * 将当前管理员的角色id取出
	 */
	public List<Integer> getRoleIds() {
		if(roles.isEmpty())
			return null;
		List<Integer> list = 
			new ArrayList<Integer>();
		for(Role r : roles) {
			list.add(r.getId());
		}
		return list;
	}
	
	/**
	 * 接收表单传入的一组角色ID，转换为角色对象
	 */
	public void setRoleIds(List<Integer> roleIds) {
		if(roleIds.isEmpty())
			return;
		Set<Role> roles = new HashSet<Role>();
		for(Integer roleId : roleIds) {
			Role r = new Role();
			r.setId(roleId);
			roles.add(r);
		}
		this.setRoles(roles);
	}
	
	/**
	 * 返回当前管理员角色名的字符串
	 */
	public String getRoleNames() {
		if(roles.isEmpty())
			return null;
		String name = "";
		for(Role r : roles) {
			name += "," + r.getName();
		}
		if(name.length() > 0) {
			name = name.replaceFirst(",", "");
		}
		return name;
	}	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
