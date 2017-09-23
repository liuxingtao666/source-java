package action;

import dao.CustomerDao;
import entity.Customer;

/**
 *	打开修改客户页面
 */
public class ToUpdateCustomerAction {

	//output
	private Customer cust;

	public String execute() {
		CustomerDao dao = new CustomerDao();
		cust = dao.findById();
		return "success";
	}
	
	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
}
