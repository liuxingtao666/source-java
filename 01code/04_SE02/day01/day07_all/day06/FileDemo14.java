package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * ʹ�������ڲ������ʽ�����ļ�������
 * @author Administrator
 *
 */
public class FileDemo14 {
	public static void main(String[] args) {
		
		File dir 
			= new File(".");
		
		//ʹ�������ڲ�����ʽ����������
		FileFilter filter
			= new FileFilter(){
				public boolean accept(File sub) {
					System.out.println("׼������:"+sub.getName());
					//ֻ�����ı��ļ�
					return sub.getName().endsWith(".txt");
				}
			
		};
		//��ȡ�����������������������
		File[] subs = dir.listFiles(filter);
		for(File sub : subs){
			System.out.println(sub.getName());
		}
	}
}




