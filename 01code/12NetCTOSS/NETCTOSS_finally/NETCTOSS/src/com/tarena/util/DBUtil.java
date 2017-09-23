package com.tarena.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static String user;
	private static String password;
	private static String url;
	private static String driver;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	static {
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream(
					"db.properties"));
			user = p.getProperty("user");
			password = p.getProperty("password");
			url = p.getProperty("url");
			driver = p.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("读取数据库配置文件失败！");
		}
	}

	public static Connection getConnection() {
		Connection con = tl.get();
		if (con == null) {
			try {
				con = DriverManager.getConnection(url, user,
						password);
				tl.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tl.get();
	}

	public static void closeConnection() {
		if (tl.get() != null) {
			try {
				tl.get().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tl.set(null);
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
		closeConnection();
	}

}
