package entity;

import java.util.List;

/**
 *	�ͻ�ʵ����
 */
public class Customer {

	private String name; // ����
	private String password; // ����
	private String desc; // ���
	private boolean marry; // �Ƿ��ѻ�

	private String sex; // �Ա�
	private List<String> travelCities; // ȥ���ĳ���
	private String home; // ����

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isMarry() {
		return marry;
	}

	public void setMarry(boolean marry) {
		this.marry = marry;
	}

	public String getHome() {
		return home;
	}

	public List<String> getTravelCities() {
		return travelCities;
	}

	public void setTravelCities(List<String> travelCities) {
		this.travelCities = travelCities;
	}

	public void setHome(String home) {
		this.home = home;
	}

}
