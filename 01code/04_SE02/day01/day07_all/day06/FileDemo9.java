package day06;

import java.io.File;

/**
 * 获取一个目录下的所有子项的名字
 * @author Administrator
 *
 */
public class FileDemo9 {
	public static void main(String[] args) {
		
		File dir = new File(".");
		//判断是否存在
		if(dir.exists()){
			//判断是否为目录
			if(dir.isDirectory()){
				/*
				 * String[] list()
				 * 该方法用于获取目录中的
				 * 所有子项的名字
				 */
				String[] subs 
					= dir.list();
				for(String name : subs){
					System.out.println(name);
				}
			}
		}
	}
}



