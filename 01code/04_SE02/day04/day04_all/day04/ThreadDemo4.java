package day04;
/**
 * ��̨�߳�
 * @author Administrator
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		/*
		 * Rose
		 * ������:ǰ̨�߳�
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
				System.out.println("rose:����������AAAAAaaaaaa....");
				System.out.println("��ͨ.");
			}
		};
		
		/*
		 * Jack
		 * ������:��̨�߳�
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
		//����Ϊ�ػ��̡߳�����start����ǰ����
		jack.setDaemon(true);
		jack.start();
	}
}





