package com.tarena.dao;

/**
 *	�Զ����쳣�����ڷ�װDAO�׳����쳣��Ϣ��
 *	�����ڴ����в����쳣�󣬽����װ��
 *	DaoException�׳�����������ͬ���ڵ����ҵ�
 *	����ʱ���Ϳ���֪���쳣�Ѿ����й�������
 *	�����ٴδ����쳣��
 */
public class DaoException extends Exception {

	/**
	 * ʵ����ʱ��Ҫ���ṩ��ȷ���쳣��Ϣ��
	 * �Լ�ԭʼ���쳣��ջ��Ϣ��
	 */
	public DaoException(
		String message, Throwable cause) {
		super(message, cause);
	}

}
