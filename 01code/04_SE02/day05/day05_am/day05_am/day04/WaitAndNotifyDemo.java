package day04;
/**
 * 线程协调工作
 * @author Administrator
 *
 */
public class WaitAndNotifyDemo {
	//图片是否下载完毕了
	private static boolean isFinish = false; 
	
	public static void main(String[] args) {
		
		//协调对象
		final Object obj = new Object();
		
		
		Thread download
			= new Thread(){
			public void run(){
				System.out.println("download:开始下载图片");
				for(int i=1;i<=100;i++){
					System.out.println(
							"download:下载了"+i+"%");
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("download:下载完毕!");
				isFinish = true;
				
				//通知显示线程可以显示图片了
				synchronized (obj) {
					obj.notify();
				}
			}
		};
		
		
		Thread showImage
			= new Thread(){
			public void run(){
				System.out.println(
						"showImage:开始显示图片");
				
				//这里应该等待下载线程完成下载
				try {
					synchronized (obj) {
						obj.wait();
					}			
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(!isFinish){
					throw 
					  new RuntimeException(
						"图片没有下载完毕!显示失败!");
				}
				System.out.println(
						"showImage:显示图片正常!");
			}
		};
		
		
		
		showImage.start();
		download.start();
		
		
	}
}











