package com.tarena.action.cost;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Cost;

public class FindCostAction {

	private int page = 1;
	private int totalPages;
	private int pageSize;
	private String baseCostSort = "sort_asc";//基费排序
	private String baseDurationSort = "sort_asc";//时长排序
	
	public String getBaseCostSort() {
		return baseCostSort;
	}

	public void setBaseCostSort(String baseCostSort) {
		this.baseCostSort = baseCostSort;
	}

	public String getBaseDurationSort() {
		return baseDurationSort;
	}

	public void setBaseDurationSort(String baseDurationSort) {
		this.baseDurationSort = baseDurationSort;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	private List<Cost> feeList;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Cost> getFeeList() {
		return feeList;
	}

	public void setFeeList(List<Cost> feeList) {
		this.feeList = feeList;
	}

	public String execute() {
		try {
			feeList = DAOFactory.getCostDAO().findByPage(page, pageSize, baseCostSort, baseDurationSort);
			totalPages = DAOFactory.getCostDAO().findTotalPages(pageSize);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}

}
