package com.tarena.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.entity.Admin;
import com.tarena.util.DBUtil;
import com.tarena.vo.AdminVO;

public class AdminDaoImpl implements IAdminDao {

	public List<AdminVO> findByCondition(
			Integer privilegeId, 
			String roleName,
			int page, int pageSize) 
			throws DaoException {
		List<AdminVO> list = 
			new ArrayList<AdminVO>();
		
		Connection con = 
			DBUtil.getConnection();
		//查询管理员
		List<Object> params = 
			new ArrayList<Object>();
		String sql = "select * from (" +
				"	select a.*,rownum r from admin_info a " +
				"	where id in (" +
				"		select ai.id " +
				"		from admin_info ai " +
				"		inner join admin_role ar on ai.id=ar.admin_id " +
				"		inner join role_info ri on ri.id=ar.role_id " +
				"		inner join role_privilege rp on ri.id=rp.role_id " +
				"		where 1=1 ";
		if(privilegeId != null) {
			sql += " and rp.privilege_id=? ";
			params.add(privilegeId);
		}
		if(roleName != null
				&& roleName.length() > 0) {
			sql += " and ri.name like '%'||?||'%' ";
			params.add(roleName);
		}
		sql += "	) " +
				") where r<? and r>?";
		params.add(page*pageSize+1);
		params.add((page-1)*pageSize);
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			for(int i=0;i<params.size();i++) {
				ps.setObject(i+1, params.get(i));
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AdminVO vo = createAdminVO(rs);
				// 查询管理员对应的角色
				String sql2 = "select name from role_info " +
						"where id in (" +
						" select role_id from admin_role " +
						" where admin_id=?" +
						")";
				PreparedStatement ps2 = 
					con.prepareStatement(sql2);
				ps2.setObject(1, vo.getId());
				ResultSet rs2 = ps2.executeQuery();
				String names = "";
				while(rs2.next()) {
					String name = rs2.getString(1);
					names += "," + name;
				}
				if(names.length() > 0) {
					names = names.replaceFirst(",", "");
				}
				
				vo.setRolesName(names);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"查询管理员失败！",e);
		} finally {
			DBUtil.close();
		}
		
		return list;
	}

	private AdminVO createAdminVO(
			ResultSet rs) throws SQLException {
		AdminVO a = new AdminVO();
		a.setId(rs.getInt("id"));
		a.setAdminCode(rs.getString("admin_code"));
		a.setPassword(rs.getString("password"));
		a.setName(rs.getString("name"));
		a.setTelephone(rs.getString("telephone"));
		a.setEmail(rs.getString("email"));
		a.setEnrollDate(rs.getDate("enrolldate"));
		return a;
	}	
	
	public int findTotalPage(Integer privilegeId, String roleName, int pageSize)
			throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void resetPassword(
			List<Integer> ids) 
		throws DaoException {
		if(ids == null
				|| ids.size() ==0) {
			return;
		}
		
		Connection con = DBUtil.getConnection();
		String sql = "update admin_info " +
				"set password='123456' " +
				"where id in (";
		for(int i=0;i<ids.size();i++) {
			if(i == 0) {
				sql += "?";
			} else {
				sql += ",?";
			}
		}
		sql += ")";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			for(int i=0;i<ids.size();i++) {
				ps.setObject(i+1, ids.get(i));
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"重置密码失败！",e);
		} finally {
			DBUtil.close();
		}
	}
	
	public static void main(String[] args) throws DaoException {
		AdminDaoImpl dao = 
			new AdminDaoImpl();
		List<Integer> list = 
			new ArrayList<Integer>();
		list.add(9);
		list.add(10);
		dao.resetPassword(list);
	}

}
