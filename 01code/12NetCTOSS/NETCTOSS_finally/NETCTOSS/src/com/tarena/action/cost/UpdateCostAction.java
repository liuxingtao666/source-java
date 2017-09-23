package com.tarena.action.cost;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.cost.ICostDao;
import com.tarena.entity.Cost;

public class UpdateCostAction {

	//  ‰»Î
	private Cost cost;
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

	public String execute() {
		ICostDao dao = DAOFactory.getCostDAO();
		try {
			dao.update(cost);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}

}
