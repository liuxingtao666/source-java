package com.tarena.aspect;

/**
 *	������������ڷ����쳣ʱ��¼��־
 */
public class ExceptionBean {

	public void execute(Exception e) {
		//ģ�⽫�쳣��Ϣ��¼����־
		StackTraceElement[] elems = 
			e.getStackTrace();
		System.out.println(elems[0]);
	}
	
}
