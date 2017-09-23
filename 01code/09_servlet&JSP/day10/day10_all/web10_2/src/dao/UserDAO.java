package dao;

import java.sql.*;

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
	
	/**
	 * 返回数据库生成的主键
	 */
	public int save(User user) throws Exception{
		int id = -1;
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement(
					"insert into t_user" +
					"(username,name,pwd,gender) " +
					"values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getName());
			stat.setString(3, user.getPwd());
			stat.setString(4, user.getGender());
			stat.executeUpdate();
			ResultSet rst = stat.getGeneratedKeys();
			if(rst.next()){
				id = rst.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return id;
	}
	
}
