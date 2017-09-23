package com.tarena.action.cost;

import java.util.List;
import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.cost.ICostDao;
import com.tarena.entity.Cost;

/**
 *	��ѯ�ʷ�����
 */
public class FindCostAction {
	//input
	private int page = 1;//��ǰҳ��Ĭ��Ϊ1
	private int pageSize = 5;//ҳ����
	//output
	private List<Cost> costs;
	private int totalPage;//��ҳ��

	/**
	 * ҵ�񷽷���ʵ�ֲ�ѯ�ʷѵ�ҵ��
	 */
	public String execute() {
		ICostDao dao = 
			DaoFactory.getCostDao();
		try {
			//��ѯĳһҳ�ʷ����ݲ����
			costs = dao.findByPage(
					page, pageSize);
			//��ѯ��ҳ��
			totalPage = dao.findTotalPage(
					pageSize);
		} catch (DaoException e) {
			e.printStackTrace();
			//�����쳣��ȥ����ҳ��
			return "error";
		}
		//����ִ�н�����ȥ�ʷ��б�ҳ��
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
