package day05;

public class ExceptionDemo3 {
	public static void main(String[] args) {
		
		try {
			
			String str = null;
			System.out.println(str.length());
		//�����쳣�Ĳ�������
		} catch (NullPointerException e) {
			
		//�����쳣�Ĳ�������	
		} catch (Exception e){
			
		}
		
	}
}
