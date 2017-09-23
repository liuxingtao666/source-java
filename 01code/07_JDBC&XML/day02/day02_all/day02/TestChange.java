package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		change(1,8,5000);
	}
	
	/**
	 * ת�˹���
	 * @param from ת���˺�
	 * @param to ת���˺�
	 * @param money ת�˽��
	 */
	public static void change(
		int from,int to,double money){
		Connection con = null;
		try{
			//��ȡ���ݿ�����connection
			Class.forName(
				"oracle.jdbc.OracleDriver");
			String url = 
				"jdbc:oracle:thin:@192.168.0.23:1521:tarena10g";
			con = DriverManager.getConnection(
				url,"jsd1402","jsd1402");
			//�ر������Զ��ύ
			con.setAutoCommit(false);
			//1.���ת���˺�from����Ƿ���ڵ���ת��money
			String sql1 = "select money " +
				"from d_account where no=?";
			PreparedStatement pst = 
				con.prepareStatement(sql1);
			pst.setInt(1, from);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				//��ȡfrom�˺Ž��
				double db_money = 
						rs.getDouble("money");
				//�ж��˻�����Ƿ�>=ת�˽��
				if(db_money >= money){
					//2.����ת�ˣ���fromת���˺ż�ȥ
					String sql2 = "update D_ACCOUNT " +
						"set MONEY=MONEY-? where no=?";
					pst = con.prepareStatement(sql2);
					pst.setDouble(1, money);
					pst.setInt(2, from);
					pst.executeUpdate();//����ת���˺Ž��
					//��toת���˺ż���
					String sql3 = "update D_ACCOUNT " +
						"set MONEY=MONEY+? where no=?";
					pst = con.prepareStatement(sql3);
					pst.setDouble(1, money);
					pst.setInt(2, to);
					//rows��ʾupdate�˼��м�¼
					int rows = pst.executeUpdate();//����ת���˺Ž��
					if(rows == 0){
						con.rollback();//����ǰ��DML����
						System.out.println("ת��ʧ��,ת���˺Ų�����");
					}else{
						con.commit();//�ύǰ��DML����
						System.out.println("ת�˳ɹ�!");
					}
				}else{
					System.out.println("�˻����㣡");
				}
			}else{
				System.out.println(from+"�˺Ų�����!");
			}
			
		}catch(Exception ex){
			try {
				con.rollback();//����ǰ��DML����
			} catch (SQLException e) {
			}
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

}
