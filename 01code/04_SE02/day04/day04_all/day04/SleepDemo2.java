package day04;
/**
 * 中断异常
 * @author Administrator
 *
 */
public class SleepDemo2 {
	public static void main(String[] args) {
		
		final Thread lin 	
			= new Thread(){
			public void run(){
				System.out.println(
						"林:刚美完容，睡觉吧。");
				try {
					Thread.sleep(10000000);
				} catch (InterruptedException e) {
					System.out.println(
						"林:干嘛呢！干嘛呢！干嘛呢！都破了相了！");
				}
				
			}
		};
		lin.start();
		
		Thread huang 
			= new Thread(){
			public void run(){
				System.out.println("黄:开始砸墙!");		
				for(int i=0;i<5;i++){
					System.out.println("黄:80！");
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
					}
				}				
				System.out.println("旁白:咣当！");
				System.out.println("黄:搞定!");
				/*
				 * 一个方法的局部内部类中若想引用该方法的
				 * 其它局部变量，这些变量必须是final的
				 */
				lin.interrupt();//中断lin的睡眠阻塞
			}
		};
		
		huang.start();
		
		
	}
}




