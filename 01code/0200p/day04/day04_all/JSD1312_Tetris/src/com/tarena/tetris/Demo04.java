package com.tarena.tetris;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Timer     ��ʱ��
 * TimerTask ��ʱ�������� 
 * schedule: �ճ̣��ƻ� 
 */
public class Demo04 {
	public static void main(String[] args) {
		Timer timer = new Timer();
//		TimerTask task = new TimerTask(){
//			public void run() {
//				System.out.println("HI"); 
//			}
//		};
//		//����ʱ�����ִ�мƻ�
//		timer.schedule(task, 1000, 1000);
		//���ϣ�1000�����Ժ�ִ��tastһ�Σ��ټ��1000����ִ��
		//��һ��
		timer.schedule(new TimerTask(){
			public void run(){
				System.out.println("HI");
			}
		}, 1000, 1000);
	}
}
