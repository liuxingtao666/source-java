package com.tarena.entity;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {

	private String name;
	private Integer age;
	// ĳ�˵�����Ů�� 
	private List<String> girls;
	// ĳ�˵Ĳ���
	private Set<String> books;
	// ĳ��Ů�ѵ�qq��key��Ů������value��qq
	private Map<String, String> girlQQ;
	// ĳ�˵Ĺ��£�key����ݣ�value���¼�
	private Properties events;
	
	public void tell() {
		System.out.println("�ҽ�" + name);
		System.out.println("�ҽ���" + age + "��");
		System.out.println("�ҵ�Ů���У�");
		for(String g : girls) {
			System.out.println(g);
		}
		System.out.println("���кö��飺");
		for(String b : books){
			System.out.println(b);
		}
		Iterator<String> it = 
			girlQQ.keySet().iterator();
		while(it.hasNext()) {
			String girl = it.next();
			String qq = girlQQ.get(girl);
			System.out.println(girl + "��QQ�ǣ�"
					+ qq);
		}
		Iterator<Object> it1 = 
			events.keySet().iterator();
		while(it1.hasNext()) {
			String year = (String) it1.next();
			String event = 
				events.getProperty(year);
			System.out.println(
				"��" + year + "�귢����" +
				event + "��"
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
