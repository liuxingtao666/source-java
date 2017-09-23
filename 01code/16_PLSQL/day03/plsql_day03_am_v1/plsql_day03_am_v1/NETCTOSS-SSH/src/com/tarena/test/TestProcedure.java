package com.tarena.test;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.tarena.util.DBUtil;

/**
 *	演示调用存储过程
 */
public class TestProcedure {

	public static void main(String[] args) 
		throws Exception {
		Connection con = DBUtil.getConnection();
		CallableStatement cs = 
			con.prepareCall("call sum_sub(?,?,?,?)");
		//设置in型参数
		cs.setInt(1, 20);
		cs.setInt(2, 8);
		//设置out型参数
		cs.registerOutParameter(
				3, java.sql.Types.INTEGER);
		cs.registerOutParameter(
				4, java.sql.Types.INTEGER);
		//执行存储过程
		cs.execute();
		//获取输出参数的值
		System.out.println(cs.getInt(3));
		System.out.println(cs.getInt(4));
	}

}
