package com.tarena.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *	���ݿ����ӹ����ࡣ
 *	1.��ȡ����
 *	2.�ر�����
 */
public class DBUtil {
	
	private static String user; //�û���
	private static String password; //����
	private static String url; //URL
	private static String driver; //����
	
	/*
	 * �ھ�̬������ж�ȡһ�����ݿ�
	 * ���Ӳ������ɡ�
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
				"��ȡ���ݿ����Ӳ���ʧ�ܣ�", e);
		}
	}

	/**
	 * Alt+Shift+J
	 * ��ȡ����
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"��ȡ���ݿ�����ʧ��", e);
		}
		return con;
	}
	
	/**
	 * �ر�����
	 */
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(
						"�ر����ݿ�����ʧ�ܣ�", e);
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
