package com.bo;
/**
 * �����ÿһ��ʵ�����ڱ�ʾһ��ƥ��ɶԵ���־
 * @author Administrator
 *
 */
public class LogRec {
	//��¼��־
	private LogData login;
	//�ǳ���־
	private LogData logout;
	
	/**
	 * ���췽�����ڳ�ʼ�������־
	 */
	public LogRec(
			LogData login, 
			LogData logout) {
		/*
		 * ��Ҫ���ж�
		 */
		if(login.getType()!=7){
			throw new RuntimeException("���ǵ�¼��־");
		}
		if(logout.getType()!=8){
			throw new RuntimeException("���ǵǳ���־");
		}
		if(!login.getUser().equals(logout.getUser())){
			throw new RuntimeException("����ͬһ���û�");
		}
		if(login.getPid()!=logout.getPid()){
			throw new RuntimeException("����ͬһ������");
		}
		if(!login.getHost().equals(logout.getHost())){
			throw new RuntimeException("����ͬһ������");
		}
		
		this.login = login;
		this.logout = logout;	
	}
	
	
	@Override
	public String toString() {
		return login.toString()+"|"+logout.toString();
	}
	
}

