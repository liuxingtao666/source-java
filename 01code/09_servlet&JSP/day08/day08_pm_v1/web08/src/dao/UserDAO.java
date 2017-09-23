package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import entity.User;

public class UserDAO {
	public User findByUsername(String username) throws Exception{
		User user = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement(
					"select * from t_user where " +
					"username=?");
			stat.setString(1, username);
			rst = stat.executeQuery();
			if(rst.next()){
				user = new User();
				user.setId(rst.getInt("id"));
				user.setUsername(username);
				user.setPwd(rst.getString("pwd"));
				user.setName(rst.getString("name"));
				user.setGender(rst.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return user;
	}
}
