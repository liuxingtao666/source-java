package day04;
/**
 * 创建线程的第一种方式
 * @author Administrator
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		Thread t1 = new Person1();	
		Thread t2 = new Person2();
		/*
		 * 注意！启动线程不要调用run方法
		 * 而是要调用start方法。
		 * start的方法是将线程纳入线程调度。
		 * start方法调用完毕后，线程会很快
		 * 执行起来，并自动调用run方法。
		 */
		t1.start();
		t2.start();
	}
}
/**
 * Thread类  线程类
 * 其每一个实例表示一个可以并发运行的线程
 * @author Administrator
 *
 */
class Person1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊?");
		}
	}
}
class Person2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是修水管的");
		}
	}
}



