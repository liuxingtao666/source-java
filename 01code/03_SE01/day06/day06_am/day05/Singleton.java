package day05;
/**
 * ����ģʽ
 * @author Administrator
 *
 */
public class Singleton {
	/*
	 * �ڶ���:����һ��˽�еľ�̬�ĵ�ǰ���͵�����
	 *       ����ʵ����
	 * Ŀ��:����Ψһ��һ��ʵ��
	 */
	private static Singleton instance 
						= new Singleton();
	
	/*
	 * ��һ��:˽�л����췽��
	 * Ŀ��:��ֹ���ͨ��new�ؼ���ʵ������ǰ����
	 */
	private Singleton(){
		
	}
	
	/*
	 * ������:����һ����̬�ģ�
	 * ���еĻ�ȡ��ǰ����ʵ���ķ���
	 * Ŀ��:ʹ�����Ի�ȡ������ʵ��
	 */
	public static Singleton getInstance(){
		return instance;
	}
}




