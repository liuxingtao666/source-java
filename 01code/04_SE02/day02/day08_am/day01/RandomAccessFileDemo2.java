package day01;

import java.io.RandomAccessFile;

/**
 * ���ڻ����д����
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args)throws Exception {
		RandomAccessFile raf
			= new RandomAccessFile(
				"demo.txt","rw"
			);		
		String str = "��Һã����ǲ���ʦ!";
		/*
		 * ����ϵͳĬ�ϱ��뼯���ַ���ת��Ϊ
		 * ��Ӧ���ֽ�����
		 */
//		byte[] data = str.getBytes();
		
		/*
		 * ʹ��ָ���ı��뼯���ַ���ת��Ϊ�ֽ�
		 */
		byte[] data = str.getBytes("UTF-8");
		//���ֽ�����һ����д��
		raf.write(data);
		
		raf.close();
	}
}











