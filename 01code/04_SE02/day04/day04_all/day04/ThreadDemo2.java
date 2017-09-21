package day04;
/**
 * 线程创建的第二种方式
 * @author Administrator
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		/*
		 * 使用Runnable的作用是
		 * 线程与线程体 解耦
		 */
		Runnable r1 = new Person3();
		Runnable r2 = new Person4();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
	}
}

class Person3 implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊?");
		}
	}
}
class Person4 implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("我是修电表的");
		}
	}
}




