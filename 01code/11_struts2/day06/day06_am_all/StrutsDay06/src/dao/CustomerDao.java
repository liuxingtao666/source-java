package dao;

import java.util.ArrayList;
import java.util.List;

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
		list.add("shanghai");
		list.add("guangzhou");
		list.add("shenzhen");
		list.add("xiamen");
		list.add("nanchang");
		c.setTravelCities(list);
		
		c.setHome("shenzhen");
		
		return c;
	}
	
}
