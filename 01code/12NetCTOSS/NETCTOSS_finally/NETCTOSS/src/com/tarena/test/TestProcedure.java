package com.tarena.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.tarena.util.DBUtil;

public class TestProcedure {
	
	public static void main(String[] args) throws Exception {
		Connection con = DBUtil.getConnection();
		CallableStatement cs = 
				con.prepareCall("call sumsub(?,?,?,?)");
		cs.setInt(1,10);
		cs.setInt(2,50);
		cs.registerOutParameter(3,Types.INTEGER);	
		cs.registerOutParameter(4,Types.INTEGER);	
		cs.execute();
		System.out.println(cs.getInt(3));
		System.out.println(cs.getInt(4));
	}

}
