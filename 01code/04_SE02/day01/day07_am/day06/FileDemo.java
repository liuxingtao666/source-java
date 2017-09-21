package day06;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File��
 * ���������ļ�ϵͳ�е�һ���ļ���Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo {
	public static void main(String[] args)throws IOException {
		/*
		 * ���������õĿ�ƽ̨�ԣ����Ǿ�Ӧ������
		 * ʹ����ƽ̨(����ϵͳ)��ص����ݡ�����·��
		 * ���ԣ�����Ӧ��������ʹ�����·����
		 * ".":��ʾ��ǰĿ¼
		 *     eclipse�µĵ�ǰĿ¼ָ���ǵ�ǰ����
		 *     ��������Ŀ�ĸ�Ŀ¼���������SE01���
		 *     Ŀ¼��
		 */
		
		File file 
			= new File(
					"." + 
					File.separator + 
					"test.txt");
		
		/*
		 * ��ȡ�ļ���
		 */
		String name = file.getName();
		System.out.println("�ļ���:"+name);
		
		/*
		 * ��ȡ�ļ���С
		 * ����ֵ���ֽ�Ϊ��λ
		 */
		long length = file.length();
		System.out.println("�ļ�:"+length+"�ֽ�");
		
		/*
		 * ��ȡ����޸�ʱ��
		 * 2014��3��26��, 9:30:25
		 */
		long lastm = file.lastModified();
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy��M��d��, H:m:s"
			);
		//�ֽ�longתΪDate
		Date date = new Date(lastm);
		String lastStr = sdf.format(date);
		System.out.println("�޸�����:"+lastStr);

		/*
		 * ��ȡ·��
		 */
		String path = file.getPath();
		System.out.println(path);
		
		/*
		 * ��ȡ����·��
		 */
		String absPath 
			= file.getAbsolutePath();
		System.out.println(absPath);
		
		/*
		 * ��ȡϵͳ��׼�ľ���·��
		 * �÷�����Ҫ�����쳣
		 */
		String cPath
			= file.getCanonicalPath();
		System.out.println(cPath);
		
		/*
		 * �鿴File���������ļ��Ƿ���ʵ����
		 */
		boolean exists = file.exists();
		System.out.println(
				"�Ƿ����:"+exists);
		
		/*
		 * �鿴��ǰFile�����������Ƿ�Ϊһ���ļ�
		 */
		boolean isFile = file.isFile();
		System.out.println(
				"�Ƿ�Ϊ�ļ�:"+isFile);
		
		/*
		 * �鿴��ǰFile�����������Ƿ�Ϊһ��Ŀ¼
		 */
		boolean isDir = file.isDirectory();
		System.out.println(
				"�Ƿ�ΪĿ¼:"+isDir);
		
		/*
		 *  �ļ��Ƿ�ɶ�
		 */
		boolean canRead
			= file.canRead();
		System.out.println(
				"�Ƿ�ɶ�:"+canRead);
		
		/*
		 * �Ƿ��д
		 */
		boolean canWrite
			= file.canWrite();
		System.out.println(
				"�Ƿ��д:"+canWrite);
		
		/*
		 * �Ƿ������
		 */
		boolean canExecute
			= file.canExecute();
		System.out.println(
				"�Ƿ������:"+canExecute);
		/*
		 * �Ƿ�Ϊ�����ļ�
		 * file.isHidden()
		 */
		
		
		
		
		
		
		
		
	}
}



