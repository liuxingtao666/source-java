package day06;

import java.io.File;
import java.io.IOException;

/**
 * �����ļ���
 * ����һ���ļ�
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args)throws IOException {
		/*
		 * ����Ŀ��Ŀ¼�´���һ��demo.txt���ļ�
		 * 1:����һ��File�������������ļ�
		 * 2:�жϸ��ļ��ڸ�·�����Ƿ���ʵ����
		 * 3:���������򴴽����ļ�
		 */
		
		//ֱ�Ӹ��ļ�����ͬ���ڵ�ǰĿ¼���������ļ�
		File file 
			= new File("demo.txt");
//		file
//			= new File("."+File.separator+"demo.txt");
		
		//�ж��Ƿ����
		if(!file.exists()){
			
			//�����ļ�
			file.createNewFile();
			
		}
	}
}







