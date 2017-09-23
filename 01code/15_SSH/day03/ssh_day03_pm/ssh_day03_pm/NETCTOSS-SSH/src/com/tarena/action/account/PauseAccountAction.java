package com.tarena.action.account;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.DaoFactory;
import com.tarena.dao.account.IAccountDao;
import com.tarena.dao.service.IServiceDao;

/**
 *	��ͣ�����˺�
 */
@Controller
@Scope("prototype")
public class PauseAccountAction {
	
	@Resource
	private IAccountDao accDao;

	//input
	private int id;
	//output
	private Map<String, Object> info = 
		new HashMap<String, Object>();
	
	public String execute() {
		IServiceDao serdao = 
			DaoFactory.getServiceDao();
		try {
			//��ͣ�����˺�
			accDao.pause(id);
			//��ͣ�������˺Ŷ�Ӧ��ҵ���˺�
			serdao.pauseByAccount(id);
			//��ͣ�ɹ���������ʾ
			info.put("success", true);
			info.put("message", "��ͣ�ɹ�.");
		} catch (DaoException e) {
			e.printStackTrace();
			//��ͣʧ�ܣ�������ʾ
			info.put("success", false);
			info.put("message", "��ͣʧ��.");
		}
		return "success";
	}
	
	public void setAccDao(IAccountDao accDao) {
		this.accDao = accDao;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<String, Object> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	
}
