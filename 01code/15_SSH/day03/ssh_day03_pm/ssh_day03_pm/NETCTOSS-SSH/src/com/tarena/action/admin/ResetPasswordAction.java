package com.tarena.action.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tarena.dao.DaoException;
import com.tarena.dao.admin.IAdminDao;

/**
 *	密码重置Action
 */
@Controller
@Scope("prototype")
public class ResetPasswordAction {
	
	@Resource
	private IAdminDao adminDao;

	//input
	private String ids;
	//output
	private Map<String, Object> info = 
		new HashMap<String, Object>();
	
	public String execute() {
		//重新构造参数
		String[] idArray = ids.split(",");
		if(idArray != null
				&& idArray.length > 0) {
			List<Integer> idList = 
				new ArrayList<Integer>();
			for(String id : idArray) {
				idList.add(Integer.valueOf(id));
			}
			try {
				//执行重置
				adminDao.resetPassword(idList);
				info.put("success", true);
				info.put("message", "密码重置成功.");
			} catch (DaoException e) {
				e.printStackTrace();
				info.put("success", false);
				info.put("message", "密码重置失败.");
			}
		}
		return "success";
	}
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Map<String, Object> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	
	
}
