package com.tarena.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tarena.entity.Admin;

/**
 *	��¼����������������ڷ���Actionǰ��
 *	�ж��û��Ƿ��¼����û�е�¼������
 *	����Action��������ת����¼ҳ�档
 */
public class LoginInterceptor 
	implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(
			ActionInvocation ai) 
		throws Exception {
		//��ȡsession
		Map<String, Object> session = 
			ai.getInvocationContext().getSession();
		//��session��ȡ��¼��Ϣ
		Admin admin = (Admin) 
			session.get("admin");
		//���ݵ�¼��Ϣ�ж��Ƿ��¼
		if(admin == null) {
			//û��¼���߻ص�¼ҳ��
			return "login";
		} else {
			//��¼�ˣ����Է���Action
			return ai.invoke();
		}
	}

}
