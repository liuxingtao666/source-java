package day04;
/**
 * �ڲ��෽ʽ�����߳�
 * @author Administrator
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//��ʽ1:
		Thread t1 
			= new Thread(){
				public void run(){
					for(int i=0;i<1000;i++){
						System.out.println(
								"����˭��?");
					}
				}
		};
		//��ʽ2:
		Runnable r
			= new Runnable(){
				public void run() {
					for(int i=0;i<1000;i++){
						System.out.println(
								"���Ƿ�����");
					}					
				}
			};
		Thread t2 = new Thread(r);
		t2.start();
	}
}




