package com.tarena.dao.role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.entity.Role;
import com.tarena.util.DBUtil;
import com.tarena.util.PrivilegeReader;
import com.tarena.vo.RoleVO;

public class RoleDaoImpl implements IRoleDao {

	public List<Role> findByPage(
			int page, int pageSize) 
			throws DaoException {
		List<RoleVO> list = 
			new ArrayList<RoleVO>();
		Connection con = DBUtil.getConnection();
		//�ȷ�ҳ��ѯ��ɫ
		String sql = "select * from (" +
				"select i.*,rownum r " +
				"from role_info i" +
				") where r<? and r>?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setObject(1, page*pageSize+1);
			ps.setObject(2, (page-1)*pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RoleVO vo = new RoleVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				//��ѯÿһ����ɫ��Ӧ��ȫ��ģ��
				String sql2 = "select privilege_id " +
						"from role_privilege " +
						"where role_id=?";
				PreparedStatement ps2 = 
					con.prepareStatement(sql2);
				ps2.setObject(1, vo.getId());
				ResultSet rs2 =
					ps2.executeQuery();
				//ģ�������ַ���
				String name = "";
				while(rs2.next()) {
					int pid = rs2.getInt(1);
					//����pidȡ��ģ����
					String pname = PrivilegeReader
							.getPrivilegeNameById(pid);
					name += "," + pname;
				}
				//ȥ�������һ����
				if(name.length() > 0) {
					name = name.replaceFirst(",", "");
				}
				//���õ���ģ�����ַ������õ�VO
				vo.setModulesName(name);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"��ҳ��ѯ��ɫʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
		
		return null;//list;
	}

	public int findTotalPage(int pageSize) throws DaoException {
		// TODO ͬѧ���Լ���ɣ���Խ�ɫ����м��㣬�ο��ʷѹ����findTotalPage
		return 0;
	}

	public void add(Role role) 
		throws DaoException {
		if(role == null)
			return;
		Connection con = 
			DBUtil.getConnection();
		//������ɫ
		String sql = "insert into role_info " +
				"values(role_seq.nextval,?)";
		try {
			con.setAutoCommit(false);
			//ִ������º󣬿��Է��ص���
			String[] columns = new String[] { "id" };
			PreparedStatement ps = 
				con.prepareStatement(sql, columns);
			ps.setObject(1, role.getName());
			ps.executeUpdate();
			
			//��ȡ�����У�������е�����ʵ����psʱָ������
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int roleId = rs.getInt(1);
			
			// ������ɫģ���м��
			List<Integer> pids = 
				null;//role.getPrivilegeIds();
			if(pids != null
					&& pids.size() > 0) {
				String sql2 = "insert into role_privilege " +
						"values(?,?)";
				PreparedStatement ps2 = 
					con.prepareStatement(sql2);
				for(Integer pid : pids) {
					ps2.setObject(1, roleId);
					ps2.setObject(2, pid);
					//����������
					ps2.addBatch();
				}
				//ִ��������
				ps2.executeBatch();
				//�ύ����
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//�ع�����
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DaoException(
				"������ɫʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
		
	}
	
	public Role findById(int id) 
		throws DaoException {
		Connection con = 
			DBUtil.getConnection();
		//��ѯ��ɫ
		String sql = "select * from role_info " +
				"where id=?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				// ��ѯ��ɫ��Ӧ��ģ��
				String sql2 = "select privilege_id from role_privilege " +
						"where role_id=?";
				PreparedStatement ps2 = 
					con.prepareStatement(sql2);
				ps2.setObject(1, id);
				ResultSet rs2 = ps2.executeQuery();
				List<Integer> pids = 
					new ArrayList<Integer>();
				while(rs2.next()) {
					int pid = rs2.getInt(1);
					pids.add(pid);
				}
//				role.setPrivilegeIds(pids);
				return role;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"����ID��ѯ��ɫʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
		
		return null;
	}
	
	public void update(Role role) 
		throws DaoException {
		if(role == null)
			return;
		Connection con = 
			DBUtil.getConnection();
		//�޸Ľ�ɫ
		String sql = "update role_info " +
				"set name=? where id=?";
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setObject(1, role.getName());
			ps.setObject(2, role.getId());
			ps.executeUpdate();
			// ɾ���ɵĽ�ɫ��Ӧģ��
			String sql2 = "delete from role_privilege " +
					"where role_id=?";
			PreparedStatement ps2 = 
				con.prepareStatement(sql2);
			ps2.setObject(1, role.getId());
			ps2.executeUpdate();
			//���²����µĽ�ɫ��Ӧģ��
			List<Integer> pids = 
				null;//role.getPrivilegeIds();
			if(pids != null
					&& pids.size() > 0) {
				String sql3 = "insert into " +
						"role_privilege values(?,?)";
				PreparedStatement ps3 = 
					con.prepareStatement(sql3);
				for(Integer pid : pids) {
					ps3.setObject(1, role.getId());
					ps3.setObject(2, pid);
					ps3.addBatch();
				}
				ps3.executeBatch();
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DaoException(
				"�޸Ľ�ɫʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
		
	}
	
	public static void main(String[] args) throws DaoException {
		RoleDaoImpl dao = new RoleDaoImpl();
		Role role = dao.findById(143);
		role.setName("������");
		List<Integer> pids = 
			new ArrayList<Integer>();
		pids.add(4);
		pids.add(6);
		pids.add(7);
//		role.setPrivilegeIds(pids);
		dao.update(role);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
