package day06;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File类
 * 用于描述文件系统中的一个文件或目录
 * @author Administrator
 *
 */
public class FileDemo {
	public static void main(String[] args)throws IOException {
		/*
		 * 想做到更好的跨平台性，我们就应当避免
		 * 使用与平台(操作系统)相关的内容。比如路径
		 * 所以，我们应当尽可能使用相对路径。
		 * ".":表示当前目录
		 *     eclipse下的当前目录指的是当前程序
		 *     所属的项目的根目录。这里就是SE01这个
		 *     目录。
		 */
		
		File file 
			= new File(
					"." + 
					File.separator + 
					"test.txt");
		
		/*
		 * 获取文件名
		 */
		String name = file.getName();
		System.out.println("文件名:"+name);
		
		/*
		 * 获取文件大小
		 * 返回值以字节为单位
		 */
		long length = file.length();
		System.out.println("文件:"+length+"字节");
		
		/*
		 * 获取最后修改时间
		 * 2014年3月26日, 9:30:25
		 */
		long lastm = file.lastModified();
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy年M月d日, H:m:s"
			);
		//现将long转为Date
		Date date = new Date(lastm);
		String lastStr = sdf.format(date);
		System.out.println("修改日期:"+lastStr);

		/*
		 * 获取路径
		 */
		String path = file.getPath();
		System.out.println(path);
		
		/*
		 * 获取绝对路径
		 */
		String absPath 
			= file.getAbsolutePath();
		System.out.println(absPath);
		
		/*
		 * 获取系统标准的绝对路径
		 * 该方法需要补货异常
		 */
		String cPath
			= file.getCanonicalPath();
		System.out.println(cPath);
		
		/*
		 * 查看File所描述的文件是否真实存在
		 */
		boolean exists = file.exists();
		System.out.println(
				"是否存在:"+exists);
		
		/*
		 * 查看当前File对象描述的是否为一个文件
		 */
		boolean isFile = file.isFile();
		System.out.println(
				"是否为文件:"+isFile);
		
		/*
		 * 查看当前File对象描述的是否为一个目录
		 */
		boolean isDir = file.isDirectory();
		System.out.println(
				"是否为目录:"+isDir);
		
		/*
		 *  文件是否可读
		 */
		boolean canRead
			= file.canRead();
		System.out.println(
				"是否可读:"+canRead);
		
		/*
		 * 是否可写
		 */
		boolean canWrite
			= file.canWrite();
		System.out.println(
				"是否可写:"+canWrite);
		
		/*
		 * 是否可运行
		 */
		boolean canExecute
			= file.canExecute();
		System.out.println(
				"是否可运行:"+canExecute);
		/*
		 * 是否为隐藏文件
		 * file.isHidden()
		 */
		
		
		
		
		
		
		
		
	}
}



