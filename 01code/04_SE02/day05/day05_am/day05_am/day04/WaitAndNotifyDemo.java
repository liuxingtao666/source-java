package day04;
/**
 * �߳�Э������
 * @author Administrator
 *
 */
public class WaitAndNotifyDemo {
	//ͼƬ�Ƿ����������
	private static boolean isFinish = false; 
	
	public static void main(String[] args) {
		
		//Э������
		final Object obj = new Object();
		
		
		Thread download
			= new Thread(){
			public void run(){
				System.out.println("download:��ʼ����ͼƬ");
				for(int i=1;i<=100;i++){
					System.out.println(
							"download:������"+i+"%");
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("download:�������!");
				isFinish = true;
				
				//֪ͨ��ʾ�߳̿�����ʾͼƬ��
				synchronized (obj) {
					obj.notify();
				}
			}
		};
		
		
		Thread showImage
			= new Thread(){
			public void run(){
				System.out.println(
						"showImage:��ʼ��ʾͼƬ");
				
				//����Ӧ�õȴ������߳��������
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
						"ͼƬû���������!��ʾʧ��!");
				}
				System.out.println(
						"showImage:��ʾͼƬ����!");
			}
		};
		
		
		
		showImage.start();
		download.start();
		
		
	}
}











