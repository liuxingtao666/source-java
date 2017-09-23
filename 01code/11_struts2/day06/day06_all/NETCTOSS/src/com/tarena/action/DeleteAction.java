package com.tarena.action;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.ICostDao;

/**
 *	删除一条资费数据
 */
public class DeleteAction {

	//input
	private int id;

	public String execute() {
		ICostDao dao = 
			DaoFactory.getCostDao();
		try {
			dao.delete(id);
		} catch (DaoException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
