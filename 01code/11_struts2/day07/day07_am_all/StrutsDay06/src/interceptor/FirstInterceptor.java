package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *	��һ�����������
 */
public class FirstInterceptor 
	implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	/* 
	 * �����������ط������������ص�Action��
	 * ���󣬲�������ǰ�����غ��ܶ�Action
	 * ������չ��
	 * ��������£�Ҳ���Ծܾ��û�����Action��
	 */
	public String intercept(
			ActionInvocation ai) 
		throws Exception {
		//ģ������ǰ����չҵ��
		System.out.println("FirstInterceptor����ǰ...");
		/*
		 * ai.invoke()����������������Action
		 * �ķ����������������û�е��ø÷�����
		 * ��ô���������������Action������
		 * �����á�
		 * */
		ai.invoke();
		//ģ�����Action�����չҵ��
		System.out.println("FirstInterceptor���غ�...");
		/*
		 * �������ķ���ֵҲ������ƥ��result�ģ�
		 * �����������ط�����û�е���ai.invoke
		 * ʱ���÷���ֵ��Ч�����������Action��
		 * ��һ������Action�ķ���ֵƥ��result��
		 * ����������¸÷���ֵʧЧ��
		 * */
		return "error";
	}

}
