package com.bo;
/**
 * �����ÿһ��ʵ����������wtmpx�ϵ�һ����־��Ϣ
 * @author Administrator
 *
 */
public class LogData {
	/**
	 * һ����־��ռ�õ��ֽ���
	 */
	public static final int LOG_LENGTH = 372;
	
	/*
	 * �û���
	 */
	private String user;
	/**
	 * User��һ����־��Ϣ�п�ʼ���ֽ�λ��
	 */
	public static final int USER_OFFSET = 0;
	/**
	 * User��ռ�õ��ֽ���
	 */
	public static final int USER_LENGTH = 32;
	
	/*
	 * ����id
	 */
	private int pid;
	/**
	 * PID��һ����־�ļ�����ʼ�ֽ�λ��
	 */
	public static final int PID_OFFSET = 68;
	
	
	/*
	 * ��¼����
	 */
	private short type;
	
	public static final int TYPE_OFFSET = 72;
	
	/*
	 * ��¼ʱ��
	 */
	private int time;
	
	public static final int TIME_OFFSET = 80;
	
	/*
	 * ��¼�û���������ַ
	 */
	private String host;
	
	public static final int HOST_OFFSET = 114;
	public static final int HOST_LENGTH = 258;

	public LogData(String user, int pid, short type, int time, String host) {
		this.user = user;
		this.pid = pid;
		this.type = type;
		this.time = time;
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	@Override
	public String toString() {
		return user+","+pid+","+type+","+time+","+host;
	}
	
}
