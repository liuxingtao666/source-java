package day06;

import java.io.File;

/**
 * ɾ��һ��Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo8 {
	public static void main(String[] args) {
		/*
		 * ɾ��demoĿ¼
		 * ɾ��Ŀ¼ʱҪ��֤��Ŀ¼ʱ�յ�(�������κ�����)
		 * ����ɾ��ʧ��
		 */
		File dir
			= new File("demo");
		if(dir.exists()){
			dir.delete();
		}
		System.out.println("ɾ�����");
	}
}

/*
 * 
 * С��ҵ:
 * 	��дһ������
 *  public void delete(File file){
 *    ...
 *  }
 *  
 *  �÷����������ǽ�������File��������ʾ���ļ�
 *  ��Ŀ¼ɾ����
 *  Ŀ¼���ܺ������
 */


