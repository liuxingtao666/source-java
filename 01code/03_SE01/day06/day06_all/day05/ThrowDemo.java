package day05;
/**
 * �����׳��쳣
 * @author Administrator
 *
 */
public class ThrowDemo {
	public static void main(String[] args) {
		Human h = new Human();
		try{
			h.setAge(1000);//�׳��쳣
			/*
			 * �׳��쳣��try�����д��д���
			 * ֮�µ����д����������ִ�У�����
			 * ����catch�С�
			 */
			System.out.println(h);//����ִ��
		}catch(Exception e){
			System.out.println("���䲻�Ϸ�");
		}
		
	}
}

class Human{
	private int age;
	
	public void setAge(int age){
		if(age<=0||age>130){
			throw new RuntimeException("��������������");
		}
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "�ҽ���:"+age+"��";
	}
}





