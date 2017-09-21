package day06;

import java.io.File;
import java.io.IOException;

/**
 * 操作文件：
 * 创建一个文件
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args)throws IOException {
		/*
		 * 在项目根目录下创建一个demo.txt的文件
		 * 1:创建一个File对象，来描述该文件
		 * 2:判断该文件在该路径下是否真实存在
		 * 3:若不存在则创建该文件
		 */
		
		//直接给文件名等同于在当前目录下描述该文件
		File file 
			= new File("demo.txt");
//		file
//			= new File("."+File.separator+"demo.txt");
		
		//判断是否存在
		if(!file.exists()){
			
			//创建文件
			file.createNewFile();
			
		}
	}
}







