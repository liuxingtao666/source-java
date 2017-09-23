package com.tarena.entity;

import java.util.List;

public class Role {

	private String id;
	private String name;
	private List<Integer> privilegeIds;
	private String privilegeNames;

	public void setPrivilegeNames(String privilegeNames) {
		this.privilegeNames = privilegeNames;
	}

	public String getPrivilegeNames() {
		return privilegeNames;
	}

	public List<Integer> getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(List<Integer> privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
