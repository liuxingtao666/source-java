package com.tarena.action.cost;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Cost;

public class CostNameValidateAction {
	
	private Integer id;

	private String name;

	private boolean pass;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute() {
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		Cost cost = null;
		try {
			cost = DAOFactory.getCostDAO().findByName(id, name);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}

		if (cost == null) {
			pass = true;
		} else {
			pass = false;
		}

		return "success";
	}

}
