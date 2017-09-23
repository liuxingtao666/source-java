package com.tarena.action;

import java.util.List;
import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.ICostDao;
import com.tarena.entity.Cost;

/**
 *	��ѯ�ʷ�����
 */
public class FindCostAction {
	
	//output
	private List<Cost> costs;

	/**
	 * ҵ�񷽷���ʵ�ֲ�ѯ�ʷѵ�ҵ��
	 */
	public String execute() {
		ICostDao dao = 
			DaoFactory.getCostDao();
		try {
			//��ѯȫ���ʷ����ݲ����
			costs = dao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
			//�����쳣��ȥ����ҳ��
			return "error";
		}
		//����ִ�н�����ȥ�ʷ��б�ҳ��
		return "success";
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	
}
