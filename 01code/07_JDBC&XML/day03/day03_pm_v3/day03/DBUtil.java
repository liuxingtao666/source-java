package day03;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	static String username = "";
	static String password = "";
	static String url = "";
	static String driver = "";
	static DataSource ds;//连接池
	
	static{//只执行一次
		try{
			Properties props = new Properties();
			//将src/db.properties以InputStream方式载入
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
			//创建连接池对象
			BasicDataSource bds = 
				new BasicDataSource();
			//设置连接参数
			bds.setDriverClassName(driver);
			bds.setUrl(url);
			bds.setUsername(username);
			bds.setPassword(password);
			bds.setMaxActive(10);//最大连接数
			bds.setInitialSize(2);//初始连接数
			ds = bds;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 返回一个Connection连接对象
	 * @return
	 * @throws Exception 
	 */
	public static Connection getConnection() throws Exception{
		return ds.getConnection();
	}
	
	/**
	 * 关闭传入的Connection对象
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
		closeResultSet(rs);//先关闭rs
		closeStatement(stat);//再关闭stat
		closeConnection(con);//最后关闭con
	}
	
	public static void close(
			Connection con,
			Statement stat){
			closeStatement(stat);//先关闭stat
			closeConnection(con);//最后关闭con
		}
	
}
