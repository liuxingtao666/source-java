package com.tarena.util;

import java.io.IOException;
import java.util.Properties;

public class MessageUtil {

	private static Properties props = 
		new Properties();
	
	static {
		try {
			props.load(MessageUtil.class
					.getClassLoader()
					.getResourceAsStream(
						"message.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ݴ����key����message.properties
	 * ��ȡֵ����
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		return props.getProperty(key);
	}
	
}
