package com.tarena.task;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

/**
 *	�����˵����ݵ�������Ҫ��ͨ��
 *	���ô洢�����Զ������˵����ݡ�
 */
@Component
public class CreateBillTask {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * ���ô洢���̣��Զ������˵�����
	 */
	public void calculate() {
		Session session = 
			sessionFactory.openSession();
		Connection con = session.connection();
		try {
			/*
			 * ����Ӧ�õ��ô洢����GBILL_ALL��
			 * ���Զ�������˵����ݡ�
			 * ���ڸù��̽�Ϊ���ӣ���������ʾ��
			 * ���������͵���һ���򵥵Ĵ洢����
			 * proc1����ʾ����ʵ�ֵ��ֶΡ�
			 * */
			CallableStatement cs =
				con.prepareCall("call proc1()");
			cs.execute();
			System.out.println(
				"----->���ô洢����proc1...");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
