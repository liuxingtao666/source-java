package com.tarena.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *	Ȩ�޼��������
 */
public class PrivilegeInterceptor implements Interceptor {

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		
		// �жϵ�ǰ�û����ʵ�ģ��
		int currPrivilege = 0; // Ĭ��0�ǵ�¼��ҳ
		String uri = ServletActionContext.getRequest().getRequestURI();
		if (uri.contains("role")) {
			currPrivilege = 1;
		} else if (uri.contains("admin")) {
			currPrivilege = 2;
		} else if (uri.contains("cost")) {
			currPrivilege = 3;
		} else if (uri.contains("account")) {
			currPrivilege = 4;
		} else if (uri.contains("service")) {
			currPrivilege = 5;
		} else if (uri.contains("bill")) {
			currPrivilege = 6;
		} else if (uri.contains("report")) {
			currPrivilege = 7;
		} else {
			currPrivilege = 0;
		}

		Map<String, Object> session = ai.getInvocationContext().getSession();
		session.put("currPrivilege", currPrivilege);
		
		return ai.invoke();
	}
	
}
