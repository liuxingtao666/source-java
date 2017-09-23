package com.tarena.tetris;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Timer     定时器
 * TimerTask 定时器的任务 
 * schedule: 日程，计划 
 */
public class Demo04 {
	public static void main(String[] args) {
		Timer timer = new Timer();
//		TimerTask task = new TimerTask(){
//			public void run() {
//				System.out.println("HI"); 
//			}
//		};
//		//给定时器添加执行计划
//		timer.schedule(task, 1000, 1000);
		//如上：1000毫秒以后执行tast一次，再间隔1000毫秒执行
		//下一次
		timer.schedule(new TimerTask(){
			public void run(){
				System.out.println("HI");
			}
		}, 1000, 1000);
	}
}
