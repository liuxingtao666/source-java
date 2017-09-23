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
			System.out.println("请输入用户名:");
			String name = sc.nextLine();
			System.out.println("请输入密码:");
			String pwd = sc.nextLine();
			checkLogin(name,pwd);
		}
	}
	
	public static void checkLogin(
		String name,String pwd){
		Connection con = null;
		try{
			//获取连接Connection
			Class.forName(
				"oracle.jdbc.OracleDriver");
			String url = 
				"jdbc:oracle:thin:@192.168.0.23:1521:tarena10g";
			con = DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			//发送执行一个select语句
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
			//获取ResultSet结果
			rs.next();//将指针移到第一行记录
			int size = rs.getInt(1);//获取第一个字段值
			//如果结果值为0表示错误;为1表示正确
			if(size == 0){
				System.out.println("登录失败");
			}else{
				System.out.println("登录成功");
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
