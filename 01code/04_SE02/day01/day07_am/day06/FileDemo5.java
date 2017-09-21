package day06;

import java.io.File;

/**
 * 创建多级目录
 * @author Administrator
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * 在项目根目录下创建目录:
		 * a/b/c/d/e/f/g/h/i
		 */
		
		File dir
			= new File(
				"a" + File.separator +
				"b" + File.separator +
				"c" + File.separator +
				"d" + File.separator +
				"e" + File.separator +
				"f" + File.separator +
				"g" + File.separator +
				"h" + File.separator +
				"i"
			);
		
		if(!dir.exists()){
			/*
			 * mkdirs
			 * 该方法在创建当前目录时会自动创建
			 * 所有不存在的父目录
			 */
			dir.mkdirs();
		}
		System.out.println("创建完毕了");
	}
}




