package com.tarena.action.cost;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.cost.ICostDao;
import com.tarena.entity.Cost;

public class AddCostAction {

	//  ‰»Î
	private Cost cost;

	public String execute() {
		ICostDao dao = DAOFactory.getCostDAO();
		try {
			dao.insert(cost);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

}
