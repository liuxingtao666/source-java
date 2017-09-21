package day06;

import java.io.File;

/**
 * 删除一个目录
 * @author Administrator
 *
 */
public class FileDemo8 {
	public static void main(String[] args) {
		/*
		 * 删除demo目录
		 * 删除目录时要保证该目录时空的(不含有任何子项)
		 * 否则删除失败
		 */
		File dir
			= new File("demo");
		if(dir.exists()){
			dir.delete();
		}
		System.out.println("删除完毕");
	}
}

/*
 * 
 * 小作业:
 * 	编写一个方法
 *  public void delete(File file){
 *    ...
 *  }
 *  
 *  该方法的作用是将给定的File对象所表示的文件
 *  或目录删除。
 *  目录可能含有子项。
 */


