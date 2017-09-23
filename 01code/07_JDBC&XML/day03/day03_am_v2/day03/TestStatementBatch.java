package day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatementBatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		testBatch();
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
	}
	
	/**
	 * ��������1000����¼
	 */
	public static void testBatch(){
		Connection con = null;
		
		try {
			//��ȡ����
			Class.forName(
				"oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.0.26:1521:tarena";
			con = DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			//����1000����¼
			Statement stat = 
				con.createStatement();
			for(int i=1;i<=1000;i++){
				String name = "test"+i;
				String sql = "insert into b001(id,name) " +
					"values ("+i+",'"+name+"')";
				stat.addBatch(sql);//��sql����batch
				//�����50��ִ��һ��
				if(i % 50 == 0){
					stat.executeBatch();//����ִ��batch
				}
			}
			stat.executeBatch();//�����һ��sqlִ��
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
	
	

}
