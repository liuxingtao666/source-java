package day04;
/**
 * �����̵߳ĵ�һ�ַ�ʽ
 * @author Administrator
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		Thread t1 = new Person1();	
		Thread t2 = new Person2();
		/*
		 * ע�⣡�����̲߳�Ҫ����run����
		 * ����Ҫ����start������
		 * start�ķ����ǽ��߳������̵߳��ȡ�
		 * start����������Ϻ��̻߳�ܿ�
		 * ִ�����������Զ�����run������
		 */
		t1.start();
		t2.start();
	}
}
/**
 * Thread��  �߳���
 * ��ÿһ��ʵ����ʾһ�����Բ������е��߳�
 * @author Administrator
 *
 */
class Person1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("����˭��?");
		}
	}
}
class Person2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("������ˮ�ܵ�");
		}
	}
}



