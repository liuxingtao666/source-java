package test;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Tickets;

import util.HibernateUtil;

/**
 *	ģ���Ʊ��Ʊ����
 */
public class TicketsClient 
	extends Thread {
	
	// ��Ʊ����
	private int buy = 1;

	@Override
	public void run() {
		String threadName = 
			Thread.currentThread().getName();
		//��ѯ��Ʊ
		Session session = 
			HibernateUtil.getSession();
		//ʹ��LockMode.UPGRADE�ӱ�����
		Tickets tickets = (Tickets)
			session.get(Tickets.class, 1, LockMode.UPGRADE);
		//�жϹ�Ʊ�����Ƿ񳬹���Ʊ
		if(tickets.getAmount() >= buy) {
			//ģ��12306�Ŀ�
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			//��Ʊ���㣬������
			//������Ʊ
			int t = tickets.getAmount()-buy;
			tickets.setAmount(t);
			Transaction ts = 
				session.beginTransaction();
			try {
				//������Ʊ
				session.update(tickets);
				ts.commit();
				//��Ʊ�ɹ�����ʾ
				System.out.println(
					"�ͻ�[" + threadName +
					"]����Ʊ"+buy+"�ţ���ƱΪ"+
					t + "�š�"
				);
			} catch (HibernateException e) {
				e.printStackTrace();
				ts.rollback();
				System.out.println(
					"�Բ���["	+ threadName + 
					"]��Ʊ���۳���"
				);
			}
		} else {
			//��Ʊ���㣬������
			System.out.println(
				"�Բ���["	+ threadName + 
				"]����Ʊ���㡣"
			);
		}
		
		HibernateUtil.close();
	}
	
	public static void main(String[] args) {
		//ģ������¹�Ʊ������Ʊ
		Thread t1 = new TicketsClient();
		t1.start();
		//ģ���йش幺Ʊ������Ʊ
		Thread t2 = new TicketsClient();
		t2.start();
	}
	
}
