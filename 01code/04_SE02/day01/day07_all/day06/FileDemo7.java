package day06;

import java.io.File;

/**
 * ɾ��һ���ļ�
 * @author Administrator
 *
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * ɾ����Ŀ¼�µ�demo.txt
		 */
		File file
			= new File("demo.txt");
		
		/*
		 * delete()��������ɾ���ļ���Ŀ¼
		 */
		if(file.exists()){
			file.delete();
		}
		System.out.println("ɾ�����");
	}
}








