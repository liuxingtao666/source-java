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
	
	//初始化DataSource
	private static ComboPooledDataSource ds = 
		new ComboPooledDataSource();
	//初始化ThreadLocal，用于管理连接
	private static ThreadLocal<Connection> tl = 
		new ThreadLocal<Connection>();
	
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
			//初始化连接数
			ds.setInitialPoolSize(
				Integer.valueOf(p.getProperty("initSize")));
			//最大连接数
			ds.setMaxPoolSize(
				Integer.valueOf(p.getProperty("maxSize")));
			//最小连接数
			ds.setMinPoolSize(
				Integer.valueOf(p.getProperty("minSize")));
			//重新获取连接时的增长的连接数
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
		//试图从ThreadLocal中取当前线程的连接
		Connection con = tl.get();
		//如果没有取到连接，则获取新连接
		if(con == null) {
			try {
				con = ds.getConnection();
				//将新获取的连接装入ThreadLocal，与当前线程绑定
				tl.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(
						"获取数据库连接失败", e);
			}
		}
		return con;
	}
	
	/**
	 * 关闭连接
	 */
	public static void close() {
		//取出当前线程对应的连接
		Connection con = tl.get();
		if(con != null) {
			try {
				//将连接还回池中
				con.close();
				//从ThreadLocal中清理当前线程对应的连接
				tl.remove();
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
		DBUtil.close();
	}
	
}
