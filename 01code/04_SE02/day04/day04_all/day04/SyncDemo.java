package day04;
/**
 * �̰߳�ȫ����
 * @author Administrator
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		final Table table = new Table();
		
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					System.out.println(
						getName()+":"+bean);
					Thread.yield();
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					System.out.println(
						getName()+":"+bean);
					Thread.yield();
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class Table{
	//�����ϵĶ���
	private int beans = 20;
	//��ȡһ������
	public int getBean(){
		
		synchronized(this){
			if(beans == 0){
				throw new RuntimeException("û��!");
			}
			Thread.yield();
			return beans--;
		}
	}
}







