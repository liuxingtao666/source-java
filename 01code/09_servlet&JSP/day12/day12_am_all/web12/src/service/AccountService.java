package service;

import java.util.Random;

import dao.AccountDAO;
import entity.Account;

public class AccountService {
	public String apply(String accountNo,
			double amount) throws Exception{
		//step1,看帐号是否存在，如果不存在,
		//要提示用户
		AccountDAO dao = new AccountDAO();
		Account a = dao.findByAccountNo(accountNo);
		if(a == null){
			//帐号不存在
			//抛出一个应用异常
			throw new AccountNotExsitException();
		}
		/*
		 * step2,看余额是否充足
		 * 	amount <= balance * 10
		 */
		if(amount > a.getBalance() * 10){
			//余额不足
			throw new AccountLimitException();
		}
		//step3,生成一个序号，该序号要保存到
		//数据库，并返回
		Random r = new Random();
		String number = r.nextInt(88888) + "";
		System.out.println("保存序号:" + number 
				+ "到数据库...");
		return number;
	}
}
