package day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestScrollResultSet {
	public static void main(String[] args){
		testScroll();
	}
	
	
	public static void testScroll(){
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			//ִ��һ��select
			String sql = 
				"select id,name " +
				"from b001 " +
				"where id<10 " +
				"order by id";
			//׷��֧�ֹ���ָ����ƵĲ���
			stat = con.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stat.executeQuery(sql);
			rs.absolute(5);//��ָ��ָ�򵽵�5��
			rs.relative(-3);//��ָ��ӵ�ǰλ�������ƶ�3��
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id+" "+name);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBUtil.close(con,stat,rs);
		}
	}
	
}
