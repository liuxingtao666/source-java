package day05;
/**
 * Exception���������÷���
 * @author Administrator
 *
 */
public class ExceptionApiDemo {
	public static void main(String[] args) {
		try {
			String str = "";
			System.out.println(str.charAt(0));
		} catch (Exception e) {
			/*
			 *  ������쳣���ֵĶ�ջ��Ϣ
			 *  ���������Ǹ��ƴ��� 
			 */
			e.printStackTrace();
			//��ȡ�쳣����Ϣ
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}




