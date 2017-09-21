package day01;

import java.io.RandomAccessFile;

/**
 * ���ڻ���Ķ�д��������ɸ����ļ�
 * @author Administrator
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args)throws Exception {
		RandomAccessFile src
			= new RandomAccessFile(
				"FishGame.rar","r"	
			  );
		
		RandomAccessFile des
			= new RandomAccessFile(
				"FishGame_copy2.rar", "rw"
			  );
		
		//����һ��������
		byte[] buf = new byte[1024*10];
		//��¼ÿ�ζ�ȡ��ʵ�ʵ��ֽڳ���
		int len = 0;
		
		
		long start 
		= System.currentTimeMillis();
		
		while(  (len = src.read(buf)) != -1 ){
			des.write(buf,0,len);
		}
		
		long end 
		= System.currentTimeMillis();
		System.out.println("��ʱ:"+(end-start)+"����");
		
		src.close();
		des.close();
	}
}




