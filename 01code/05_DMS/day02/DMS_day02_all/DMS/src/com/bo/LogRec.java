package com.bo;
/**
 * 该类的每一个实例用于表示一组匹配成对的日志
 * @author Administrator
 *
 */
public class LogRec {
	//登录日志
	private LogData login;
	//登出日志
	private LogData logout;
	
	/**
	 * 构造方法用于初始化配对日志
	 */
	public LogRec(
			LogData login, 
			LogData logout) {
		/*
		 * 必要的判断
		 */
		if(login.getType()!=7){
			throw new RuntimeException("不是登录日志");
		}
		if(logout.getType()!=8){
			throw new RuntimeException("不是登出日志");
		}
		if(!login.getUser().equals(logout.getUser())){
			throw new RuntimeException("不是同一个用户");
		}
		if(login.getPid()!=logout.getPid()){
			throw new RuntimeException("不是同一个进程");
		}
		if(!login.getHost().equals(logout.getHost())){
			throw new RuntimeException("不是同一个主机");
		}
		
		this.login = login;
		this.logout = logout;	
	}
	
	
	@Override
	public String toString() {
		return login.toString()+"|"+logout.toString();
	}
	
}

