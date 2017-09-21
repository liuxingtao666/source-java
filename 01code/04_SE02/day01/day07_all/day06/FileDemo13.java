package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取一个目录下的部分子项
 * @author Administrator
 *
 */
public class FileDemo13 {
	public static void main(String[] args) {
		
		File dir
			= new File(".");		
		//创建过滤器
		FileFilter filter
			= new MyFilter();
		/*
		 * File[] listFiles(FileFilter filter)
		 * 获取满足给定过滤器条件的所有子项
		 */		
		File[] subs
			= dir.listFiles(filter);
		
		for(File sub : subs){
			System.out.println(sub.getName());
		}
	}
}

class MyFilter implements FileFilter{
	/**
	 * 该方法用于定义过滤条件
	 * 当方法返回true则参数的File对象需要保留
	 */
	public boolean accept(File sub) {
		/*
		 * 保留以"."开头的文件或目录
		 */
		return sub.getName()
		       .startsWith(".");
	}
	
}








