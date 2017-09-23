package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestUser {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String name = sc.nextLine();
		System.out.println("请输入密码:");
		String pwd = sc.nextLine();
		System.out.println("请输入性别:");
		String sex = sc.nextLine();
		System.out.println("请输入生日:");
		String birth = sc.nextLine();
		System.out.println("正在操作中...");
		insert(name,pwd,sex,birth);
	}
	
	public static void insert(
		String name,String pwd,
		String sex,String birth){
		Connection con = null;
		try{
			//获取连接Connection
			Class.forName(
				"oracle.jdbc.OracleDriver");
			String url = 
				"jdbc:oracle:thin:@192.168.0.23:1521:tarena10g";
			con = DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			//发送执行SQL
			String sql = 
			"insert into d_users " +
			"(id,name,pwd,sex,birth) " +
			"values " +
			"(user_seq.nextval,'"+name+"','"
			  +pwd+"','"+sex+"'," +
			"to_date('"+birth+"','yyyy-mm-dd'))";
			//重要:便于调试
			System.out.println(sql);
			Statement stat = 
					con.createStatement();
			stat.executeUpdate(sql);
			System.out.println("添加成功");
		}catch(Exception ex){
			System.out.println("添加失败");
//			ex.printStackTrace();
		}finally{
			try {
				con.close();//释放连接资源
			} catch (SQLException e) {
			}
		}
	}
	
}
