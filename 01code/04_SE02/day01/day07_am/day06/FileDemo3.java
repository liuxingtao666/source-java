package day06;

import java.io.File;

/**
 * ����Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		
		/*
		 * ����Ŀ�ĸ�Ŀ¼�´���Ŀ¼demo
		 */
		File dir = new File("demo");
		
		if(!dir.exists()){
			
			//����Ŀ¼
			dir.mkdir();
			
		}
	}
}









