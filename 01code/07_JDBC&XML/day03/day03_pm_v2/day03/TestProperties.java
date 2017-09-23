package day03;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		//将src/db.properties以InputStream方式载入
		InputStream inStream = 
			TestProperties.class
			.getClassLoader()
			.getResourceAsStream("db.properties");
		props.load(inStream);
		//读取props中文件信息
		String name = 
			props.getProperty("username");
		String driver = 
			props.getProperty("driver");
		System.out.println(name);
		System.out.println(driver);
	}

}
