package day05;
/**
 * �������쳣
 * @author Administrator
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try {
			String str = "a";
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			int num = Integer.parseInt(str);
		} catch (NullPointerException e) {
			System.out.println("��ָ����!");
		} catch(StringIndexOutOfBoundsException e){
			System.out.println("�ַ����±�Խ����!");
		} catch(Exception e){
			System.out.println("�������ǳ��˸���!");
		}
		
		
		System.out.println("���������");
	}
}




