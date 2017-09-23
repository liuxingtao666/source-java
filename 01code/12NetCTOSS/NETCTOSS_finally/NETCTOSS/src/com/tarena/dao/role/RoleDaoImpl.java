package com.tarena.dao.role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.entity.Role;
import com.tarena.util.DBUtil;
import com.tarena.util.PrivilegeReader;

public class RoleDaoImpl implements IRoleDao {

	@Override
	public void insertRole(Role role) throws DAOException {
		if (role == null)
			return;
		Connection con = DBUtil.getConnection();
		try {
			// ������ɫ
			String sql = "insert into ROLE_INFO values(role_seq.nextval,?)";
			int roleId = 0;
			String[] columns = { "id" };
			PreparedStatement ps = con.prepareStatement(sql, columns);
//			ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setObject(1, role.getName());
			ps.executeUpdate();

			// �õ�����ID
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			roleId = rs.getInt(1);

			// ����Ȩ��
			sql = "insert into ROLE_PRIVILEGE values(?,?)";
			ps = con.prepareStatement(sql);
			List<Integer> privilegeIds = role.getPrivilegeIds();
			if (privilegeIds != null) {
				for (Integer privilegeId : privilegeIds) {
					ps.setObject(1, roleId);
					ps.setObject(2, privilegeId);
					ps.addBatch();
				}
				ps.executeBatch();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("������ɫʧ�ܣ�", e);
		} finally {
			DBUtil.closeConnection();
		}
	}

	@Override
	public Role findById(int id) throws DAOException {
		Connection con = DBUtil.getConnection();
		try {
			// ��ѯ��ɫ
			String sql = "select * from role_info where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Role role = createRole(rs);

			// ��ѯȨ��
			sql = "select * from role_privilege where role_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<Integer> list = new ArrayList<Integer>();
			while (rs.next()) {
				int privilegeId = rs.getInt("PRIVILEGE_ID");
				list.add(privilegeId);
			}
			role.setPrivilegeIds(list);

			return role;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Role createRole(ResultSet rs) throws SQLException {
		Role r = new Role();
		r.setId(rs.getString("id"));
		r.setName(rs.getString("name"));
		return r;
	}

	@Override
	public void updateRole(Role role) throws DAOException {
		if (role == null)
			return;
		Connection con = DBUtil.getConnection();
		try {
			// �޸Ľ�ɫ
			String sql = "update role_info set name=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, role.getName());
			ps.setObject(2, role.getId());
			ps.executeUpdate();

			// ɾ��Ȩ��
			sql = "delete from ROLE_PRIVILEGE where ROLE_ID=?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, role.getId());
			ps.executeUpdate();

			// ����Ȩ��
			sql = "insert into ROLE_PRIVILEGE values(?,?)";
			ps = con.prepareStatement(sql);
			List<Integer> privilegeIds = role.getPrivilegeIds();
			if (privilegeIds != null) {
				for (Integer privilegeId : privilegeIds) {
					ps.setObject(1, role.getId());
					ps.setObject(2, privilegeId);
					ps.addBatch();
				}
				ps.executeBatch();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("�޸Ľ�ɫʧ�ܣ�", e);
		} finally {
			DBUtil.closeConnection();
		}
	}

	@Override
	public List<Role> findAll() throws DAOException {
		String sql = "select * from role_info";
		Connection con = DBUtil.getConnection();
		List<Role> roles = new ArrayList<Role>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Role role = createRole(rs);
				
				sql = "select * from role_privilege where role_id=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.valueOf(role.getId()));
				ResultSet rs2 = ps.executeQuery();
				List<String> privilegeNameList = new ArrayList<String>();
				while (rs2.next()) {
					int privilegeId = rs2.getInt("privilege_id");
					String privilegeName = PrivilegeReader.getPrivilegeNameById(privilegeId);
					privilegeNameList.add(privilegeName);
				}
				String nameStr = "";
				for(int i=0;i<privilegeNameList.size();i++){
					if(i==0){
						nameStr += privilegeNameList.get(i);
					} else {
						nameStr += "," + privilegeNameList.get(i);
					}
				}
				role.setPrivilegeNames(nameStr);
				
				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("��ѯ��ɫʧ�ܣ�", e);
		} finally {
			DBUtil.closeConnection();
		}
		
		return roles;
	}
	
	public static void main(String[] args) throws Exception {
		IRoleDao dao = new RoleDaoImpl();
		Role role = new Role();
		role.setName("����");
		dao.insertRole(role);
		
	}

}
