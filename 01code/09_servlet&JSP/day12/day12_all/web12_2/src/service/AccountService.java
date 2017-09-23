package service;

import java.util.Random;

import dao.AccountDAO;
import entity.Account;

public class AccountService {
	public String apply(String accountNo,
			double amount) throws Exception{
		//step1,���ʺ��Ƿ���ڣ����������,
		//Ҫ��ʾ�û�
		AccountDAO dao = new AccountDAO();
		Account a = dao.findByAccountNo(accountNo);
		if(a == null){
			//�ʺŲ�����
			//�׳�һ��Ӧ���쳣
			throw new AccountNotExsitException();
		}
		/*
		 * step2,������Ƿ����
		 * 	amount <= balance * 10
		 */
		if(amount > a.getBalance() * 10){
			//����
			throw new AccountLimitException();
		}
		//step3,����һ����ţ������Ҫ���浽
		//���ݿ⣬������
		Random r = new Random();
		String number = r.nextInt(88888) + "";
		System.out.println("�������:" + number 
				+ "�����ݿ�...");
		return number;
	}
}
