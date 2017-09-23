package dao;

import java.util.ArrayList;
import java.util.List;

import entity.City;
import entity.Customer;

public class CustomerDao {

	/**
	 * ģ�����ID��ѯ�ͻ�
	 */
	public Customer findById() {
		Customer c = new Customer();
		c.setName("����");
		c.setPassword("zs123");
		c.setDesc("�л����񹲺͹�����");
		c.setMarry(true);
		c.setSex("M");
		
		List<String> list = 
			new ArrayList<String>();
		list.add("beijing");
		list.add("guangzhou");
		list.add("shenzhen");
		list.add("nanchang");
		c.setTravelCities(list);
		
		c.setHome("shenzhen");
		
		return c;
	}
	
	/**
	 * ģ���ѯȫ���ĳ���
	 */
	public List<City> findAllCities() {
		List<City> list = new ArrayList<City>();
		City c1 = new City();
		c1.setCode("beijing");
		c1.setName("����");
		list.add(c1);
		City c2 = new City();
		c2.setCode("shanghai");
		c2.setName("�Ϻ�");
		list.add(c2);
		City c3 = new City();
		c3.setCode("guangzhou");
		c3.setName("����");
		list.add(c3);
		City c4 = new City();
		c4.setCode("shenzhen");
		c4.setName("����");
		list.add(c4);
		City c5 = new City();
		c5.setCode("xiamen");
		c5.setName("����");
		list.add(c5);
		City c6 = new City();
		c6.setCode("nanchang");
		c6.setName("�ϲ�");
		list.add(c6);
		return list;
	}
	
}
