package day06;

import java.io.File;

/**
 * ��ȡһ��Ŀ¼�µ���������
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
			 *  ��ȡĿ¼�µ��������� 
			 */
			File[] subs 
				= dir.listFiles();
			for(File sub : subs){
				if(sub.isDirectory()){
					System.out.println(
						"Ŀ¼:"+sub.getName());
				}else{
					System.out.println(
						"�ļ�:"+sub.getName());
				}
			}
		}
		
	}
}




