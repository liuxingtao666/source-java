package day01;

import java.io.RandomAccessFile;

/**
 * ��������ļ�
 * @author Administrator
 *
 */
public class RandomAccessFileDemo5 {
	public static void main(String[] args)throws Exception {
		
		RandomAccessFile raf
			= new RandomAccessFile(
				"data.dat","rw"	
			  );
		
		raf.write(97);
		
		byte[] data 
			= "hello".getBytes("utf-8");
		
		raf.write(data);
		
		/*
		 * RandomAccessFile�Ķ�д����
		 * �ǻ����α�ġ��������α굱ǰָ��
		 * �ĵط����ж�д��ÿ����д���α��
		 * �Զ�����ƶ���
		 */
		//���α��ƶ�����һ���ֽ��ϡ�
		raf.seek(0);
		
		//��ȡһ���ֽ�
		int num = raf.read();
		System.out.println(num);
		
		raf.close();
	}
}




