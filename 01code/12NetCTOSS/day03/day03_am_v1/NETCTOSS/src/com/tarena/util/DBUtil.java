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
	
	//��ʼ��DataSource
	private static ComboPooledDataSource ds = 
		new ComboPooledDataSource();
	//��ʼ��ThreadLocal�����ڹ�������
	private static ThreadLocal<Connection> tl = 
		new ThreadLocal<Connection>();
	
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
			//��ʼ��������
			ds.setInitialPoolSize(
				Integer.valueOf(p.getProperty("initSize")));
			//���������
			ds.setMaxPoolSize(
				Integer.valueOf(p.getProperty("maxSize")));
			//��С������
			ds.setMinPoolSize(
				Integer.valueOf(p.getProperty("minSize")));
			//���»�ȡ����ʱ��������������
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
		//��ͼ��ThreadLocal��ȡ��ǰ�̵߳�����
		Connection con = tl.get();
		//���û��ȡ�����ӣ����ȡ������
		if(con == null) {
			try {
				con = ds.getConnection();
				//���»�ȡ������װ��ThreadLocal���뵱ǰ�̰߳�
				tl.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(
						"��ȡ���ݿ�����ʧ��", e);
			}
		}
		return con;
	}
	
	/**
	 * �ر�����
	 */
	public static void close() {
		//ȡ����ǰ�̶߳�Ӧ������
		Connection con = tl.get();
		if(con != null) {
			try {
				//�����ӻ��س���
				con.close();
				//��ThreadLocal������ǰ�̶߳�Ӧ������
				tl.remove();
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
		DBUtil.close();
	}
	
}
