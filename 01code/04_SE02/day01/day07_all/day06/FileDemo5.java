package day06;

import java.io.File;

/**
 * �����༶Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * ����Ŀ��Ŀ¼�´���Ŀ¼:
		 * a/b/c/d/e/f/g/h/i
		 */
		
		File dir
			= new File(
				"a" + File.separator +
				"b" + File.separator +
				"c" + File.separator +
				"d" + File.separator +
				"e" + File.separator +
				"f" + File.separator +
				"g" + File.separator +
				"h" + File.separator +
				"i"
			);
		
		if(!dir.exists()){
			/*
			 * mkdirs
			 * �÷����ڴ�����ǰĿ¼ʱ���Զ�����
			 * ���в����ڵĸ�Ŀ¼
			 */
			dir.mkdirs();
		}
		System.out.println("���������");
	}
}




