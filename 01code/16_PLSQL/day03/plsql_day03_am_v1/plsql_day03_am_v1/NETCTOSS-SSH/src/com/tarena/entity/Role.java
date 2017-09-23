package com.tarena.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ��ɫʵ����
 */
public class Role {

	private Integer id;
	private String name;
	/**
	 * ��װ�м�����ݵļ���
	 */
	private Set<RolePrivilege> rolePrivileges;
	
	/**
	 * �޸�ҳ���ϵı��ʽrole.privilegeIds����
	 * ��������ʱҪ��role�����е���
	 * getPrivilegeIds����ȡֵ����Ŀǰ�������
	 * ��û�и����Լ�������Ϊ�˱��ֶ����
	 * �ṹ���������ԣ�ֻ����get������
	 * ����ǰ�����в�ѯ����rolePrivileges����
	 * �е�ֵ����ȡ��Ȩ��id���ɡ�
	 */
	public List<Integer> getPrivilegeIds() {
		Set<RolePrivilege> set = 
			this.getRolePrivileges();
		if(set.isEmpty()) 
			return null;
		List<Integer> list = 
			new ArrayList<Integer>();
		for(RolePrivilege rp : set) {
			list.add(rp.getId().getPrivilegeId());
		}
		return list;
	}
	
	/**
	 * ���еı��ʽrole.privilegeIds������
	 * �ǵ���role�����setPrivilegeIdsע��ֵ��
	 * ���Կ����ṩ�������������ע���ֵ��
	 * �������ṩ���ԡ�
	 * �����һ��ID������ת���ɶ���
	 */
	public void setPrivilegeIds(
			List<Integer> privilegeIds) {
		if(privilegeIds.isEmpty()) 
			return;
		//ת���Ķ������set������
		Set<RolePrivilege> set = 
			new HashSet<RolePrivilege>();
		for(Integer pid : privilegeIds) {
			RolePrivilege rp = new RolePrivilege();
			RolePrivilegeId rpId = 
				new RolePrivilegeId();
			rpId.setPrivilegeId(pid);
			rp.setId(rpId);
			set.add(rp);
		}
		//��ת����ļ���ת�뵱ǰ����
		this.setRolePrivileges(set);
	}
	
	public Set<RolePrivilege> getRolePrivileges() {
		return rolePrivileges;
	}
	public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
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
