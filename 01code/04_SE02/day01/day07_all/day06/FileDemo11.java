package day06;

import java.io.File;

/**
 * ���һ��Ŀ¼���������������
 * @author Administrator
 *
 */
public class FileDemo11 {
	public static void main(String[] args) {
		File dir = new File(".");
		showFile(dir);
	}
	/**
	 * ��ʾ������File�����֣�
	 * ������Ŀ¼����ʾ�����������
	 * @param file
	 */
	public static void showFile(File file){
		//1��ʾ��ǰFile������
		System.out.println(file.getName());
		//2 ����Ŀ¼����ʾ�������������
		if(file.isDirectory()){
			File[] subs
				= file.listFiles();
			for(File sub : subs){
				showFile(sub);
			}
		}
	}
	
}

/*
 *  ����20�д���������������:
 *  ���1+2+3+����100�Ľ������ÿ����һ�μӷ�
 *  �����һ�κ͡�
 *  �ڳ����в��ܳ���for,while�ȹؼ���
 */




