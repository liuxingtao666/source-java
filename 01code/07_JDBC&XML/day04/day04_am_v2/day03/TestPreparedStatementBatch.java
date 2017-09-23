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
	 * ��������1000����¼
	 */
	public static void testBatch(){
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			//����1000����¼
			String sql = 
				"insert into b001(id,name) " +
				"values (?,?)";
			pst = con.prepareStatement(sql);
			for(int i=1;i<=1000;i++){
				String name = "test"+i;
				pst.setInt(1, i);//����һ��?��ֵ
				pst.setString(2, name);//���ڶ���?��ֵ
				pst.addBatch();//����������Batch
				//�����50��ִ��һ��
				if(i % 50 == 0){
					pst.executeBatch();//����batch����ִ��
				}
			}
			pst.executeBatch();//�����һ������ִ��
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
