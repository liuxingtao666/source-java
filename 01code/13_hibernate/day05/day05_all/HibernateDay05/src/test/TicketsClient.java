package test;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Tickets;

import util.HibernateUtil;

/**
 *	模拟火车票售票窗口
 */
public class TicketsClient 
	extends Thread {
	
	// 购票张数
	private int buy = 1;

	@Override
	public void run() {
		String threadName = 
			Thread.currentThread().getName();
		//查询余票
		Session session = 
			HibernateUtil.getSession();
		//使用LockMode.UPGRADE加悲观锁
		Tickets tickets = (Tickets)
			session.get(Tickets.class, 1, LockMode.UPGRADE);
		//判断购票张数是否超过余票
		if(tickets.getAmount() >= buy) {
			//模拟12306的卡
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			//余票充足，可以买
			//计算余票
			int t = tickets.getAmount()-buy;
			tickets.setAmount(t);
			Transaction ts = 
				session.beginTransaction();
			try {
				//更新余票
				session.update(tickets);
				ts.commit();
				//购票成功，提示
				System.out.println(
					"客户[" + threadName +
					"]，购票"+buy+"张，余票为"+
					t + "张。"
				);
			} catch (HibernateException e) {
				e.printStackTrace();
				ts.rollback();
				System.out.println(
					"对不起["	+ threadName + 
					"]，票以售出。"
				);
			}
		} else {
			//余票不足，不能买
			System.out.println(
				"对不起["	+ threadName + 
				"]，余票不足。"
			);
		}
		
		HibernateUtil.close();
	}
	
	public static void main(String[] args) {
		//模拟大众寺购票窗口售票
		Thread t1 = new TicketsClient();
		t1.start();
		//模拟中关村购票窗口售票
		Thread t2 = new TicketsClient();
		t2.start();
	}
	
}
