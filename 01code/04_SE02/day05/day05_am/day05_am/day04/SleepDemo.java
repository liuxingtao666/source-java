package day04;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ˯������
 * 
 * @author Administrator
 *
 */
public class SleepDemo {
	public static void main(String[] args) {
		
		/*
		 *  14:21:55
		 */
		/*
		 * ��ȡ��ǰϵͳʱ��
		 * ��ʽ��
		 * ��ӡ����
		 * ����
		 * ѭ��
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"HH:mm:ss"
			);
		while(true){
			System.out.println(
			  sdf.format(
				new Date()
			  )
			);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		
		
	}
}








