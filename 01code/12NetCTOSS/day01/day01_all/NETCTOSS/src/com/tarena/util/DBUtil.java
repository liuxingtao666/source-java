package com.tarena.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *	数据库连接工具类。
 *	1.获取连接
 *	2.关闭连接
 */
public class DBUtil {
	
	private static ComboPooledDataSource ds = 
		new ComboPooledDataSource();
	
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
			//数据库连接参数
			ds.setJdbcUrl(p.getProperty("url"));
			ds.setDriverClass(
				p.getProperty("driverClassName"));
			ds.setUser(p.getProperty("username"));
			ds.setPassword(p.getProperty("password"));
//			//初始化连接数
			ds.setInitialPoolSize(
				Integer.valueOf(p.getProperty("initSize")));
			//最大连接数
			ds.setMaxPoolSize(
				Integer.valueOf(p.getProperty("maxSize")));
			//最小连接数
			ds.setMinPoolSize(
				Integer.valueOf(p.getProperty("minSize")));
			//重新获取连接时的连接数
			ds.setAcquireIncrement(
				Integer.valueOf(p.getProperty("increment")));
			//允许连接空闲时间
			ds.setMaxIdleTime(
				Integer.valueOf(p.getProperty("maxIdleTime")));
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
			con = ds.getConnection();
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
				//将连接还回池中
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
