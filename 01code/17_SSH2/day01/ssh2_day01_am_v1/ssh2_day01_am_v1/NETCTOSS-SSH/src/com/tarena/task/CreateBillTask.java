package com.tarena.task;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

/**
 *	创建账单数据的任务，主要是通过
 *	调用存储过程自动计算账单数据。
 */
@Component
public class CreateBillTask {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 调用存储过程，自动计算账单数据
	 */
	public void calculate() {
		Session session = 
			sessionFactory.openSession();
		Connection con = session.connection();
		try {
			/*
			 * 这里应该调用存储过程GBILL_ALL，
			 * 来自动计算出账单数据。
			 * 由于该过程较为复杂，不方便演示，
			 * 因此我这里就调用一个简单的存储过程
			 * proc1来演示这种实现的手段。
			 * */
			CallableStatement cs =
				con.prepareCall("call proc1()");
			cs.execute();
			System.out.println(
				"----->调用存储过程proc1...");
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
