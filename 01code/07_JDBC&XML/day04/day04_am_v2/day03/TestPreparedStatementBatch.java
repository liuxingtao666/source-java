package day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPreparedStatementBatch {

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
		PreparedStatement pst = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			//插入1000条记录
			String sql = 
				"insert into b001(id,name) " +
				"values (?,?)";
			pst = con.prepareStatement(sql);
			for(int i=1;i<=1000;i++){
				String name = "test"+i;
				pst.setInt(1, i);//给第一个?赋值
				pst.setString(2, name);//给第二个?赋值
				pst.addBatch();//将参数放入Batch
				//如果够50个执行一次
				if(i % 50 == 0){
					pst.executeBatch();//发送batch参数执行
				}
			}
			pst.executeBatch();//将最后一批参数执行
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		}finally{
			DBUtil.close(con,pst);
		}
	}
	
	

}
