package day04;
/**
 * �̴߳����ĵڶ��ַ�ʽ
 * @author Administrator
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		/*
		 * ʹ��Runnable��������
		 * �߳����߳��� ����
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
			System.out.println("����˭��?");
		}
	}
}
class Person4 implements Runnable{
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("�����޵���");
		}
	}
}




