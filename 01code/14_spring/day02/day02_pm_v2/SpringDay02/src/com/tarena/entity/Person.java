package com.tarena.entity;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {

	private String name;
	private Integer age;
	// 某人的历任女友 
	private List<String> girls;
	// 某人的藏书
	private Set<String> books;
	// 某人女友的qq，key是女友名，value是qq
	private Map<String, String> girlQQ;
	// 某人的故事，key是年份，value是事件
	private Properties events;
	
	public void tell() {
		System.out.println("我叫" + name);
		System.out.println("我今年" + age + "岁");
		System.out.println("我的女友有：");
		for(String g : girls) {
			System.out.println(g);
		}
		System.out.println("我有好多书：");
		for(String b : books){
			System.out.println(b);
		}
		Iterator<String> it = 
			girlQQ.keySet().iterator();
		while(it.hasNext()) {
			String girl = it.next();
			String qq = girlQQ.get(girl);
			System.out.println(girl + "的QQ是："
					+ qq);
		}
		Iterator<Object> it1 = 
			events.keySet().iterator();
		while(it1.hasNext()) {
			String year = (String) it1.next();
			String event = 
				events.getProperty(year);
			System.out.println(
				"在" + year + "年发生了" +
				event + "事"
			);
		}
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setBooks(Set<String> books) {
		this.books = books;
	}
	public void setEvents(Properties events) {
		this.events = events;
	}
	public void setGirlQQ(Map<String, String> girlQQ) {
		this.girlQQ = girlQQ;
	}
	public void setGirls(List<String> girls) {
		this.girls = girls;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
