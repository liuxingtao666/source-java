package com.tarena.action.service;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Cost;

public class ToAddServiceAction {

	private List<Cost> costList;

	public String execute() {
		try {
			costList = DAOFactory.getCostDAO().findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<Cost> getCostList() {
		return costList;
	}

	public void setCostList(List<Cost> costList) {
		this.costList = costList;
	}

}
