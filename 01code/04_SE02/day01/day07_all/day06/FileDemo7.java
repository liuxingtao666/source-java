package day06;

import java.io.File;

/**
 * 删除一个文件
 * @author Administrator
 *
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * 删除根目录下的demo.txt
		 */
		File file
			= new File("demo.txt");
		
		/*
		 * delete()方法用于删除文件或目录
		 */
		if(file.exists()){
			file.delete();
		}
		System.out.println("删除完毕");
	}
}








