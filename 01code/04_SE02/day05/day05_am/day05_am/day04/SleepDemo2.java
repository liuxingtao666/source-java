package day04;
/**
 * �ж��쳣
 * @author Administrator
 *
 */
public class SleepDemo2 {
	public static void main(String[] args) {
		
		final Thread lin 	
			= new Thread(){
			public void run(){
				System.out.println(
						"��:�������ݣ�˯���ɡ�");
				try {
					Thread.sleep(10000000);
				} catch (InterruptedException e) {
					System.out.println(
						"��:�����أ������أ������أ����������ˣ�");
				}
				
			}
		};
		lin.start();
		
		Thread huang 
			= new Thread(){
			public void run(){
				System.out.println("��:��ʼ��ǽ!");		
				for(int i=0;i<5;i++){
					System.out.println("��:80��");
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
					}
				}				
				System.out.println("�԰�:�۵���");
				System.out.println("��:�㶨!");
				/*
				 * һ�������ľֲ��ڲ������������ø÷�����
				 * �����ֲ���������Щ����������final��
				 */
				lin.interrupt();//�ж�lin��˯������
			}
		};
		
		huang.start();
		
		
	}
}




