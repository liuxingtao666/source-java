package day06;

import java.io.File;
import java.io.IOException;

/**
 * 在目录中创建文件
 * @author Administrator
 *
 */
public class FileDemo4 {
	public static void main(String[] args) throws IOException {
		/*
		 * 在demo目录下创建文件demo.dat
		 */
//		File file
//			= new File(
//				"demo" + File.separator +
//				"demo.dat"
//			);
		//当我们存在一个File对象用来描述目录了
		File dir = new File("demo");
		
		/*
		 * File(File parent,String fileName)
		 * 在指定的parent目录中表示fileName的文件或目录
		 */
		File file = new File(
					dir,"demo.dat");
		
		if(!file.exists()){
			file.createNewFile();
		}
	}
}



