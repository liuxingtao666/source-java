package day06;

import java.io.File;

/**
 * ��ȡһ��Ŀ¼�µ��������������
 * @author Administrator
 *
 */
public class FileDemo9 {
	public static void main(String[] args) {
		
		File dir = new File(".");
		//�ж��Ƿ����
		if(dir.exists()){
			//�ж��Ƿ�ΪĿ¼
			if(dir.isDirectory()){
				/*
				 * String[] list()
				 * �÷������ڻ�ȡĿ¼�е�
				 * �������������
				 */
				String[] subs 
					= dir.list();
				for(String name : subs){
					System.out.println(name);
				}
			}
		}
	}
}



