package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * 使用匿名内部类的形式创建文件过滤器
 * @author Administrator
 *
 */
public class FileDemo14 {
	public static void main(String[] args) {
		
		File dir 
			= new File(".");
		
		//使用匿名内部类形式创建过滤器
		FileFilter filter
			= new FileFilter(){
				public boolean accept(File sub) {
					System.out.println("准备过滤:"+sub.getName());
					//只保留文本文件
					return sub.getName().endsWith(".txt");
				}
			
		};
		//获取满足过滤器条件的所有子项
		File[] subs = dir.listFiles(filter);
		for(File sub : subs){
			System.out.println(sub.getName());
		}
	}
}




