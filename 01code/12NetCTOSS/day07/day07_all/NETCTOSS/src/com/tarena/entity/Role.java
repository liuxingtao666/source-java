package com.tarena.entity;

import java.util.List;

/**
 * ��ɫʵ����
 */
public class Role {

	private Integer id;
	private String name;
	/**
	 * ��װ��ɫ��Ӧ��һ��ģ��IDֵ
	 */
	private List<Integer> privilegeIds;
	
	public List<Integer> getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(List<Integer> privilegeIds) {
		this.privilegeIds = privilegeIds;
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
	
}
