package action;

import java.util.List;

import dao.CustomerDao;
import entity.City;
import entity.Customer;

/**
 *	���޸Ŀͻ�ҳ��
 */
public class ToUpdateCustomerAction {

	//output
	private Customer cust;
	private List<City> cities;

	public String execute() {
		CustomerDao dao = new CustomerDao();
		//��ѯ�ͻ�
		cust = dao.findById();
		//��ѯ���еĳ���
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
