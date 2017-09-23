package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {

	/**
	 * 建立与数据库的连接
	 * 目标IP: 192.168.0.23  
	 * SID: tarena10g
	 * 用户名和密码 jsd1402  jsd1402
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
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
			con = DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			//执行select语句
			String sql = 
				"select empno,ename,sal " +
				"from emp " +
				"order by sal";
			//获取Statement
			Statement stat = 
				con.createStatement();
			//执行select语句获取查询结果
			ResultSet rs = 
				stat.executeQuery(sql);
			//遍历rs结果数据
			while(rs.next()){
				int empno = 
					rs.getInt("empno");
				String ename = 
					rs.getString("ename");
				double sal = 
					rs.getDouble("sal");
				System.out.println(empno+" "+ename+" "+sal);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();//释放连接资源
			} catch (SQLException e) {
			}
		}

	}

}
