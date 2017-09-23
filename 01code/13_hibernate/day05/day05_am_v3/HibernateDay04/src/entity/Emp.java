package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Emp {
	
	private Integer id;
	private String name;
	private Integer age;
	private Double salary;
	private Boolean marry;
	private Date birthday;
	private Timestamp lastLoginTime;
	
	public Emp() {
		System.out.println("实例化Emp");
	}
	
	public Integer getAge() {
		System.out.println("获取年龄");
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getId() {
		System.out.println("获取ID");
		System.out.println(id);
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Boolean getMarry() {
		return marry;
	}
	public void setMarry(Boolean marry) {
		this.marry = marry;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
