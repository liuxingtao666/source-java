package com.tarena.test;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.tarena.util.DBUtil;

/**
 *	��ʾ���ô洢����
 */
public class TestProcedure {

	public static void main(String[] args) 
		throws Exception {
		Connection con = DBUtil.getConnection();
		CallableStatement cs = 
			con.prepareCall("call sum_sub(?,?,?,?)");
		//����in�Ͳ���
		cs.setInt(1, 20);
		cs.setInt(2, 8);
		//����out�Ͳ���
		cs.registerOutParameter(
				3, java.sql.Types.INTEGER);
		cs.registerOutParameter(
				4, java.sql.Types.INTEGER);
		//ִ�д洢����
		cs.execute();
		//��ȡ���������ֵ
		System.out.println(cs.getInt(3));
		System.out.println(cs.getInt(4));
	}

}
