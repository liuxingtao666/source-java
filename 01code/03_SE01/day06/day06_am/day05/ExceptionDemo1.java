package day05;
/**
 * java �쳣�������
 * @author Administrator
 *
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try{
			String str = null;
			print(str);
		}catch(NullPointerException e){
			System.out.println("��ָ����");
		}
		System.out.println("���������");
	}
	
	public static void print(String str){
		System.out.println(
				"�ַ�������:"+str.length());
	}
}




