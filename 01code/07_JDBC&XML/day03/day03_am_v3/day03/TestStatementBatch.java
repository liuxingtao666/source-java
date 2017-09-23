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
	 * 批量插入1000条记录
	 */
	public static void testBatch(){
		Connection con = null;
		
		try {
			//获取连接
			Class.forName(
				"oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.0.26:1521:tarena";
			con = DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			//插入1000条记录
			Statement stat = 
				con.createStatement();
			for(int i=1;i<=1000;i++){
				String name = "test"+i;
				String sql = "insert into b001(id,name) " +
					"values ("+i+",'"+name+"')";
				stat.addBatch(sql);//将sql加入batch
				//如果够50个执行一次
				if(i % 50 == 0){
					stat.executeBatch();//发送执行batch
				}
			}
			stat.executeBatch();//将最后一批sql执行
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
