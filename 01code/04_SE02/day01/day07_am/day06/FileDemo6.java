package day06;

import java.io.File;
import java.io.IOException;

/**
 * �����༶Ŀ¼�µ�һ���ļ�
 * @author Administrator
 *
 */
public class FileDemo6 {
	public static void main(String[] args) throws IOException {
		/*
		 * �� a/b/c/d/eĿ¼�´����ļ�demo.dat
		 * 
		 */		
		File file 
			= new File(
				"a" + File.separator +
				"b" + File.separator +
				"c" + File.separator +
				"d" + File.separator +
				"e" + File.separator +
				"demo.dat"
			);
		
		if(!file.exists()){
			//�ж������ڵ�Ŀ¼�Ƿ����			
			/*
			 * ��ȡ��ǰ�ļ��ĸ�Ŀ¼����Ӧ��File����
			 * File getParentFile()
			 */
			File dir 
				= file.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();
			}
			
			file.createNewFile();		
		}
		System.out.println("�������");
	}
}



