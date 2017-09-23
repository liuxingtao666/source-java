package com.tarena.dao.role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.util.DBUtil;
import com.tarena.util.PrivilegeReader;
import com.tarena.vo.RoleVO;

public class RoleDaoImpl implements IRoleDao {

	public List<RoleVO> findByPage(
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
		
		return list;
	}

	public int findTotalPage(int pageSize) throws DaoException {
		// TODO ͬѧ���Լ���ɣ���Խ�ɫ����м��㣬�ο��ʷѹ����findTotalPage
		return 0;
	}

	public static void main(String[] args) throws DaoException {
		RoleDaoImpl dao = new RoleDaoImpl();
		List<RoleVO> list = 
			dao.findByPage(2, 1);
		for(RoleVO vo : list) {
			System.out.println(
				vo.getId() + " " +
				vo.getName() + " " +
				vo.getModulesName()
			);
		}
	}
	
}
