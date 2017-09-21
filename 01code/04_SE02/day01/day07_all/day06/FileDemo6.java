package day06;

import java.io.File;
import java.io.IOException;

/**
 * 创建多级目录下的一个文件
 * @author Administrator
 *
 */
public class FileDemo6 {
	public static void main(String[] args) throws IOException {
		/*
		 * 在 a/b/c/d/e目录下创建文件demo.dat
		 * 
		 */		
		File file 
			= new File(
				"a" + File.separator +
				"b" + File.separator +
				"c" + File.separator +
				"d" + File.separator +
				"e" + File.separator +
				"demo.dat"
			);
		
		if(!file.exists()){
			//判断其所在的目录是否存在			
			/*
			 * 获取当前文件的父目录所对应的File对象
			 * File getParentFile()
			 */
			File dir 
				= file.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();
			}
			
			file.createNewFile();		
		}
		System.out.println("创建完毕");
	}
}



