package day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestScrollResultSet {
	public static void main(String[] args){
		testScroll();
	}
	
	
	public static void testScroll(){
		Connection con = null;
		try {
			//获取连接
			Class.forName(
				"oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.0.26:1521:tarena";
			con = DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			//执行一个select
			String sql = 
				"select id,name " +
				"from b001 " +
				"where id<10 " +
				"order by id";
			//追加支持滚动指针控制的参数
			Statement stat = 
				con.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = 
				stat.executeQuery(sql);
			rs.absolute(5);//将指针指向到第5行
			rs.relative(-3);//将指针从当前位置向上移动3行
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id+" "+name);
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
