package day06;

import java.io.File;

/**
 * 获取一个目录下的所有子项
 * @author Administrator
 *
 */
public class FileDemo10 {
	public static void main(String[] args) {
		
		File dir
			= new File(".");
		
		if(dir.exists()&&dir.isDirectory()){
			/*
			 *	File[] listFiles()
			 *  获取目录下的所有子项 
			 */
			File[] subs 
				= dir.listFiles();
			for(File sub : subs){
				if(sub.isDirectory()){
					System.out.println(
						"目录:"+sub.getName());
				}else{
					System.out.println(
						"文件:"+sub.getName());
				}
			}
		}
		
	}
}




