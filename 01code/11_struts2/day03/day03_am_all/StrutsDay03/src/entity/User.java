package entity;

/**
 *	�û�
 */
public class User {
	
	private String userName;
	private String password;
	
	public User() {
		System.out.println("ʵ����User...");
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
