package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDML {

	/**
	 * 测试执行DML语句
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
			//执行INSERT语句,提示SQL不要加最后的;
			String sql = "insert into emp " +
			"(empno,ename,job,sal,deptno) " +
			"values (1011,'Larry','CEO',10000,30)";
			//获取Statement,执行DML语句
			Statement stat = 
					con.createStatement();
			stat.executeUpdate(sql);
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
