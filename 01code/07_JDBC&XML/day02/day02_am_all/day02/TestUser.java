package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestUser {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���:");
		String name = sc.nextLine();
		System.out.println("����������:");
		String pwd = sc.nextLine();
		System.out.println("�������Ա�:");
		String sex = sc.nextLine();
		System.out.println("����������:");
		String birth = sc.nextLine();
		System.out.println("���ڲ�����...");
		insert(name,pwd,sex,birth);
	}
	
	public static void insert(
		String name,String pwd,
		String sex,String birth){
		Connection con = null;
		try{
			//��ȡ����Connection
			Class.forName(
				"oracle.jdbc.OracleDriver");
			String url = 
				"jdbc:oracle:thin:@192.168.0.23:1521:tarena10g";
			con = DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			//����ִ��SQL
			String sql = 
			"insert into d_users " +
			"(id,name,pwd,sex,birth) " +
			"values " +
			"(user_seq.nextval,'"+name+"','"
			  +pwd+"','"+sex+"'," +
			"to_date('"+birth+"','yyyy-mm-dd'))";
			//��Ҫ:���ڵ���
			System.out.println(sql);
			Statement stat = 
					con.createStatement();
			stat.executeUpdate(sql);
			System.out.println("��ӳɹ�");
		}catch(Exception ex){
			System.out.println("���ʧ��");
//			ex.printStackTrace();
		}finally{
			try {
				con.close();//�ͷ�������Դ
			} catch (SQLException e) {
			}
		}
	}
	
}
