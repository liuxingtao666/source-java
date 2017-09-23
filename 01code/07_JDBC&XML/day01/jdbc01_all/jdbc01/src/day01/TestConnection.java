package day01;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	/**
	 * 建立与数据库的连接
	 * 目标IP: 192.168.0.23  
	 * SID: tarena10g
	 * 用户名和密码 jsd1402  jsd1402
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//将ojdbc6.jar资源载入类加载器
			//注册驱动类
			Class.forName(
				"oracle.jdbc.OracleDriver");
			//编写一个连接字符串
			//jdbc:oracle:thin:@IP:1521:SID
			String url = 
				"jdbc:oracle:thin:@192.168.0.23:1521:tarena10g";
			//获取Connection对象
			//getConnection(连接字符串,用户名,密码)
			Connection con = 
				DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			System.out.println(con);
			con.close();//释放连接资源
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
