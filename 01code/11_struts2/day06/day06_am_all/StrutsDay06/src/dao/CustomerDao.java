package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Customer;

public class CustomerDao {

	/**
	 * 模拟根据ID查询客户
	 */
	public Customer findById() {
		Customer c = new Customer();
		c.setName("张三");
		c.setPassword("zs123");
		c.setDesc("中华人民共和国公民");
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
