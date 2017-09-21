package day06;

import java.io.File;

/**
 * 创建目录
 * @author Administrator
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		
		/*
		 * 在项目的根目录下创建目录demo
		 */
		File dir = new File("demo");
		
		if(!dir.exists()){
			
			//创建目录
			dir.mkdir();
			
		}
	}
}









