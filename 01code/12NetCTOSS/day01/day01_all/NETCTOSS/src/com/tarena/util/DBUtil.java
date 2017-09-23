package com.tarena.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *	���ݿ����ӹ����ࡣ
 *	1.��ȡ����
 *	2.�ر�����
 */
public class DBUtil {
	
	private static ComboPooledDataSource ds = 
		new ComboPooledDataSource();
	
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
			//���ݿ����Ӳ���
			ds.setJdbcUrl(p.getProperty("url"));
			ds.setDriverClass(
				p.getProperty("driverClassName"));
			ds.setUser(p.getProperty("username"));
			ds.setPassword(p.getProperty("password"));
//			//��ʼ��������
			ds.setInitialPoolSize(
				Integer.valueOf(p.getProperty("initSize")));
			//���������
			ds.setMaxPoolSize(
				Integer.valueOf(p.getProperty("maxSize")));
			//��С������
			ds.setMinPoolSize(
				Integer.valueOf(p.getProperty("minSize")));
			//���»�ȡ����ʱ��������
			ds.setAcquireIncrement(
				Integer.valueOf(p.getProperty("increment")));
			//�������ӿ���ʱ��
			ds.setMaxIdleTime(
				Integer.valueOf(p.getProperty("maxIdleTime")));
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
			con = ds.getConnection();
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
				//�����ӻ��س���
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
