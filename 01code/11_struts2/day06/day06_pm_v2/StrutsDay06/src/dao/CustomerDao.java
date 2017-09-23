package dao;

import java.util.ArrayList;
import java.util.List;

import entity.City;
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
		list.add("guangzhou");
		list.add("shenzhen");
		list.add("nanchang");
		c.setTravelCities(list);
		
		c.setHome("shenzhen");
		
		return c;
	}
	
	/**
	 * 模拟查询全部的城市
	 */
	public List<City> findAllCities() {
		List<City> list = new ArrayList<City>();
		City c1 = new City();
		c1.setCode("beijing");
		c1.setName("北京");
		list.add(c1);
		City c2 = new City();
		c2.setCode("shanghai");
		c2.setName("上海");
		list.add(c2);
		City c3 = new City();
		c3.setCode("guangzhou");
		c3.setName("广州");
		list.add(c3);
		City c4 = new City();
		c4.setCode("shenzhen");
		c4.setName("深圳");
		list.add(c4);
		City c5 = new City();
		c5.setCode("xiamen");
		c5.setName("厦门");
		list.add(c5);
		City c6 = new City();
		c6.setCode("nanchang");
		c6.setName("南昌");
		list.add(c6);
		return list;
	}
	
}
