package day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	/**
	 * 返回一个Connection连接对象
	 * @return
	 * @throws Exception 
	 */
	public static Connection getConnection() throws Exception{
		//获取连接
		Class.forName(
			"oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.26:1521:tarena";
		Connection con = DriverManager.getConnection(
				url,"jsd1402","jsd1402");
		return con;
	}
	
	/**
	 * 关闭传入的Connection对象
	 * @param con
	 */
	public static void closeConnection(
		Connection con){
		try {
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public static void closeStatement(
		Statement stat){
		try {
			if(stat != null){
				stat.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public static void closeResultSet(
		ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public static void close(
		Connection con,
		Statement stat,
		ResultSet rs){
		closeResultSet(rs);//先关闭rs
		closeStatement(stat);//再关闭stat
		closeConnection(con);//最后关闭con
	}
	
	public static void close(
			Connection con,
			Statement stat){
			closeStatement(stat);//先关闭stat
			closeConnection(con);//最后关闭con
		}
	
}
