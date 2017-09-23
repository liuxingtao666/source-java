package action;

import java.util.List;

import dao.CustomerDao;
import entity.City;
import entity.Customer;

/**
 *	打开修改客户页面
 */
public class ToUpdateCustomerAction {

	//output
	private Customer cust;
	private List<City> cities;

	public String execute() {
		CustomerDao dao = new CustomerDao();
		//查询客户
		cust = dao.findById();
		//查询所有的城市
		cities = dao.findAllCities();
		return "success";
	}
	
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
}
