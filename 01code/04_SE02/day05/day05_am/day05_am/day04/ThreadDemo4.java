package day04;
/**
 * 后台线程
 * @author Administrator
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		/*
		 * Rose
		 * 扮演者:前台线程
		 */
		Thread rose
			= new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println(
						"rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("rose:啊啊啊啊啊AAAAAaaaaaa....");
				System.out.println("噗通.");
			}
		};
		
		/*
		 * Jack
		 * 扮演者:后台线程
		 */
		Thread jack 
			= new Thread(){
			public void run(){
				while(true){
					System.out.println(
						"jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				
			}
		};
		rose.start();
		//设置为守护线程。调用start方法前调用
		jack.setDaemon(true);
		jack.start();
	}
}






