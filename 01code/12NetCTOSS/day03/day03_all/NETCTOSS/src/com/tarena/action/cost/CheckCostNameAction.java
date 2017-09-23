package com.tarena.action.cost;

import java.util.HashMap;
import java.util.Map;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.cost.ICostDao;
import com.tarena.entity.Cost;

/**
 *	校验资费名是否重复
 */
public class CheckCostNameAction {

	//input
	private String name;//资费名称
	//output
	private Map<String, Object> info = 
		new HashMap<String, Object>();
	
	public String execute() {
		ICostDao dao = 
			DaoFactory.getCostDao();
		try {
			// 查询资费数据
			Cost cost = dao.findByName(name);
			// 校验资费名是否重复
			if(cost == null) {
				//没重复，校验通过
				info.put("success", true);
				info.put("message", "有效的资费名.");
			} else {
				//重复了，校验失败
				info.put("success", false);
				info.put("message", "资费名重复.");
			}
		} catch (DaoException e) {
			e.printStackTrace();
			/*
			 * 异步请求时，不要转发JSP。
			 * 否则异步请求的回调函数会接收
			 * 到转发的JSP中的代码，而并不是
			 * 真正的实现了转发。
			 * */
			info.put("success", false);//程序报错
			info.put("message", "查询资费名发生异常，请联系系统管理员.");
		}
		return "success";
	}
	
	public Map<String, Object> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
