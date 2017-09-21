package day04;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 睡眠阻塞
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
		 * 获取当前系统时间
		 * 格式化
		 * 打印出来
		 * 阻塞
		 * 循环
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








