package com.tarena.action;

import java.util.List;
import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.ICostDao;
import com.tarena.entity.Cost;

/**
 *	查询资费数据
 */
public class FindCostAction {
	
	//output
	private List<Cost> costs;

	/**
	 * 业务方法，实现查询资费的业务
	 */
	public String execute() {
		ICostDao dao = 
			DaoFactory.getCostDao();
		try {
			//查询全部资费数据并输出
			costs = dao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
			//发现异常，去错误页面
			return "error";
		}
		//正常执行结束，去资费列表页面
		return "success";
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	
}
