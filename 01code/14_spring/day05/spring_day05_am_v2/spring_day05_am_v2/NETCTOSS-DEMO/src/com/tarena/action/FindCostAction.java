package com.tarena.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.ICostDao;
import com.tarena.entity.Cost;

@Controller
@Scope("prototype")
public class FindCostAction {
	
	@Resource
	private ICostDao costDao;
	
	//input
	private int page=1;
	private int pageSize;
	//output
	private List<Cost> costs;
	private int totalPage;
	
	public String load() {
		costs = costDao.findByPage(
				page, pageSize);
		totalPage = costDao.findTotalPage(
				pageSize);
		return "success";
	}
	
	public void setCostDao(ICostDao costDao) {
		this.costDao = costDao;
	}
	public List<Cost> getCosts() {
		return costs;
	}
	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
