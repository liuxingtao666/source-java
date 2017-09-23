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
		//��src/db.properties��InputStream��ʽ����
		InputStream inStream = 
			TestProperties.class
			.getClassLoader()
			.getResourceAsStream("db.properties");
		props.load(inStream);
		//��ȡprops���ļ���Ϣ
		String name = 
			props.getProperty("username");
		String driver = 
			props.getProperty("driver");
		System.out.println(name);
		System.out.println(driver);
	}

}
