package day06;

import java.io.File;
import java.io.IOException;

/**
 * ��Ŀ¼�д����ļ�
 * @author Administrator
 *
 */
public class FileDemo4 {
	public static void main(String[] args) throws IOException {
		/*
		 * ��demoĿ¼�´����ļ�demo.dat
		 */
//		File file
//			= new File(
//				"demo" + File.separator +
//				"demo.dat"
//			);
		//�����Ǵ���һ��File������������Ŀ¼��
		File dir = new File("demo");
		
		/*
		 * File(File parent,String fileName)
		 * ��ָ����parentĿ¼�б�ʾfileName���ļ���Ŀ¼
		 */
		File file = new File(
					dir,"demo.dat");
		
		if(!file.exists()){
			file.createNewFile();
		}
	}
}



