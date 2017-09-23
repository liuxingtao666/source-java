package com.tarena.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *	数据库连接工具类。
 *	1.获取连接
 *	2.关闭连接
 */
public class DBUtil {
	
	private static String user; //用户名
	private static String password; //密码
	private static String url; //URL
	private static String driver; //驱动
	
	/*
	 * 在静态代码块中读取一次数据库
	 * 连接参数即可。
	 * */
	static {
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getClassLoader()
				.getResourceAsStream(
						"db.properties"));
			user = p.getProperty("username");
			password = p.getProperty("password");
			url = p.getProperty("url");
			driver = p.getProperty("driverClassName");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"读取数据库连接参数失败！", e);
		}
	}

	/**
	 * Alt+Shift+J
	 * 获取连接
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"获取数据库连接失败", e);
		}
		return con;
	}
	
	/**
	 * 关闭连接
	 */
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(
						"关闭数据库连接失败！", e);
			}
		}
	}
	
	public static void main(String[] args) 
		throws Exception {
		Connection con = 
			DBUtil.getConnection();
		System.out.println(con);
		DBUtil.close(con);
	}
	
}
