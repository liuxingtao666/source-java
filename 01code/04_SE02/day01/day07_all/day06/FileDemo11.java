package day06;

import java.io.File;

/**
 * 输出一个目录下所有子项的名字
 * @author Administrator
 *
 */
public class FileDemo11 {
	public static void main(String[] args) {
		File dir = new File(".");
		showFile(dir);
	}
	/**
	 * 显示给定的File的名字，
	 * 若其是目录再显示其子项的名字
	 * @param file
	 */
	public static void showFile(File file){
		//1显示当前File的名字
		System.out.println(file.getName());
		//2 若是目录，显示所有子项的名字
		if(file.isDirectory()){
			File[] subs
				= file.listFiles();
			for(File sub : subs){
				showFile(sub);
			}
		}
	}
	
}

/*
 *  请用20行代码来完成下面程序:
 *  输出1+2+3+。。100的结果过。每进行一次加法
 *  就输出一次和。
 *  在程序中不能出现for,while等关键字
 */




