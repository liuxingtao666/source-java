package day03;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	static String username = "";
	static String password = "";
	static String url = "";
	static String driver = "";
	
	static{//ִֻ��һ��
		try{
			Properties props = new Properties();
			//��src/db.properties��InputStream��ʽ����
			InputStream inStream = 
				TestProperties.class
				.getClassLoader()
				.getResourceAsStream("db.properties");
			props.load(inStream);
			username = 
				props.getProperty("username");
			password = 
				props.getProperty("password");
			url = props.getProperty("url");
			driver = 
				props.getProperty("driver");
			//��ȡ����
			Class.forName(driver);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ����һ��Connection���Ӷ���
	 * @return
	 * @throws Exception 
	 */
	public static Connection getConnection() throws Exception{

		Connection con = 
			DriverManager.getConnection(
				url,username,password);
		return con;
	}
	
	/**
	 * �رմ����Connection����
	 * @param con
	 */
	public static void closeConnection(
		Connection con){
		try {
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public static void closeStatement(
		Statement stat){
		try {
			if(stat != null){
				stat.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public static void closeResultSet(
		ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
		}
	}
	
	public static void close(
		Connection con,
		Statement stat,
		ResultSet rs){
		closeResultSet(rs);//�ȹر�rs
		closeStatement(stat);//�ٹر�stat
		closeConnection(con);//���ر�con
	}
	
	public static void close(
			Connection con,
			Statement stat){
			closeStatement(stat);//�ȹر�stat
			closeConnection(con);//���ر�con
		}
	
}
