package entity;

import java.util.List;

/**
 *	客户实体类
 */
public class Customer {

	private String name; // 姓名
	private String password; // 密码
	private String desc; // 简介
	private boolean marry; // 是否已婚

	private String sex; // 性别
	private List<String> travelCities; // 去过的城市
	private String home; // 家乡

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
