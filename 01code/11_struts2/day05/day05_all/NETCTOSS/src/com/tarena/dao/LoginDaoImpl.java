package com.tarena.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tarena.entity.Admin;
import com.tarena.util.DBUtil;

public class LoginDaoImpl implements ILoginDao {

	public Admin findByCode(
			String adminCode) 
		throws DaoException {
		if(adminCode == null
				|| adminCode.length() ==0) {
			return null;
		}
		
		Connection con = 
			DBUtil.getConnection();
		String sql = "select * from admin_info " +
				"where admin_code=?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Admin a = createAdmin(rs);
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
					"查询管理员失败！", e);
		} finally {
			DBUtil.close(con);
		}
		
		return null;
	}

	private Admin createAdmin(ResultSet rs) throws SQLException {
		Admin a = new Admin();
		a.setId(rs.getInt("id"));
		a.setAdminCode(rs.getString("admin_code"));
		a.setPassword(rs.getString("password"));
		a.setName(rs.getString("name"));
		a.setTelephone(rs.getString("telephone"));
		a.setEmail(rs.getString("email"));
		a.setEnrollDate(rs.getDate("enrolldate"));
		return a;
	}
	
	public static void main(String[] args) 
		throws Exception {
		LoginDaoImpl dao = new LoginDaoImpl();
		Admin a = dao.findByCode("lhh");
		System.out.println(
			a.getId() + " " +
			a.getAdminCode() + " " +
			a.getPassword() + " " +
			a.getName()
		);
	}

}
