package com.tarena.action.cost;

import java.util.List;
import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.cost.ICostDao;
import com.tarena.entity.Cost;

/**
 *	查询资费数据
 */
public class FindCostAction {
	//input
	private int page = 1;//当前页，默认为1
	private int pageSize = 5;//页容量
	//output
	private List<Cost> costs;
	private int totalPage;//总页数

	/**
	 * 业务方法，实现查询资费的业务
	 */
	public String execute() {
		ICostDao dao = 
			DaoFactory.getCostDao();
		try {
			//查询某一页资费数据并输出
			costs = dao.findByPage(
					page, pageSize);
			//查询总页数
			totalPage = dao.findTotalPage(
					pageSize);
		} catch (DaoException e) {
			e.printStackTrace();
			//发现异常，去错误页面
			return "error";
		}
		//正常执行结束，去资费列表页面
		return "success";
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

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	
}
