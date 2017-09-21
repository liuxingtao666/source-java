package day04;
/**
 * 内部类方式创建线程
 * @author Administrator
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//方式1:
		Thread t1 
			= new Thread(){
				public void run(){
					for(int i=0;i<1000;i++){
						System.out.println(
								"你是谁啊?");
					}
				}
		};
		//方式2:
		Runnable r
			= new Runnable(){
				public void run() {
					for(int i=0;i<1000;i++){
						System.out.println(
								"我是范传奇");
					}					
				}
			};
		Thread t2 = new Thread(r);
		t2.start();
	}
}




