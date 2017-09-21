package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * ��ȡһ��Ŀ¼�µĲ�������
 * @author Administrator
 *
 */
public class FileDemo13 {
	public static void main(String[] args) {
		
		File dir
			= new File(".");		
		//����������
		FileFilter filter
			= new MyFilter();
		/*
		 * File[] listFiles(FileFilter filter)
		 * ��ȡ���������������������������
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
	 * �÷������ڶ����������
	 * ����������true�������File������Ҫ����
	 */
	public boolean accept(File sub) {
		/*
		 * ������"."��ͷ���ļ���Ŀ¼
		 */
		return sub.getName()
		       .startsWith(".");
	}
	
}








