package com.bo;
/**
 * 该类的每一个实例用于描述wtmpx上的一条日志信息
 * @author Administrator
 *
 */
public class LogData {
	/**
	 * 一条日志所占用的字节量
	 */
	public static final int LOG_LENGTH = 372;
	
	/*
	 * 用户名
	 */
	private String user;
	/**
	 * User在一条日志信息中开始的字节位置
	 */
	public static final int USER_OFFSET = 0;
	/**
	 * User所占用的字节量
	 */
	public static final int USER_LENGTH = 32;
	
	/*
	 * 进程id
	 */
	private int pid;
	/**
	 * PID在一条日志文件的起始字节位置
	 */
	public static final int PID_OFFSET = 68;
	
	
	/*
	 * 登录类型
	 */
	private short type;
	
	public static final int TYPE_OFFSET = 72;
	
	/*
	 * 登录时间
	 */
	private int time;
	
	public static final int TIME_OFFSET = 80;
	
	/*
	 * 登录用户的主机地址
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
