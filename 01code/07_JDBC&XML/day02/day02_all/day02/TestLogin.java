package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("�������û���:");
			String name = sc.nextLine();
			System.out.println("����������:");
			String pwd = sc.nextLine();
			checkLogin(name,pwd);
		}
	}
	
	public static void checkLogin(
		String name,String pwd){
		Connection con = null;
		try{
			//��ȡ����Connection
			Class.forName(
				"oracle.jdbc.OracleDriver");
			String url = 
				"jdbc:oracle:thin:@192.168.0.23:1521:tarena10g";
			con = DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			//����ִ��һ��select���
			String sql = 
			"SELECT count(1) c " +
			"FROM d_users " +
			"WHERE name='"+name+"' " +
			"AND pwd='"+pwd+"'";
			System.out.println(sql);
			Statement stat = 
				con.createStatement();
			ResultSet rs = 
				stat.executeQuery(sql);
			//��ȡResultSet���
			rs.next();//��ָ���Ƶ���һ�м�¼
			int size = rs.getInt(1);//��ȡ��һ���ֶ�ֵ
			//������ֵΪ0��ʾ����;Ϊ1��ʾ��ȷ
			if(size == 0){
				System.out.println("��¼ʧ��");
			}else{
				System.out.println("��¼�ɹ�");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
	
	
	
	

}
