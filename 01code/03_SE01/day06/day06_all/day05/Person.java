package day05;
/**
 * ģ��ģʽ  ģ����Ӧ���Ǹ�������
 * �������̹Ǽ�
 * @author Administrator
 *
 */
public abstract class Person {
	/**
	 * ģ�巽�����÷���������ɽ����Լ�
	 */
	public void sayHello(){
		
		//1�ȴ��к�
		hello();
		
		//2˵�Լ�������
		sayName();
		
		//3�����Լ������
		sayInfo();
		
		//4˵�ټ�
		System.out.println("�ټ�");
	}
	//���к�����
	public abstract void hello();
	
	//˵�Լ�������
	public abstract void sayName();
	
	//�����Լ�
	public abstract void sayInfo();
	
}





