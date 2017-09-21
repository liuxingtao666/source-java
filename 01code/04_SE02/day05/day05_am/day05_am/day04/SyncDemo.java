package day04;
/**
 * 线程安全问题
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
	//桌子上的豆子
	private int beans = 20;
	//获取一个豆子
	public int getBean(){
		
		synchronized(this){
			if(beans == 0){
				throw new RuntimeException("没了!");
			}
			Thread.yield();
			return beans--;
		}
	}
}







