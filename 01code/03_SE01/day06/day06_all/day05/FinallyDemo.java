package day05;
/**
 * finally����:���۳����Ƿ���쳣����Ҫִ��
 * @author Administrator
 *
 */
public class FinallyDemo {
	public static void main(String[] args) {
		try{
			System.out.println("�����ݿ⽨������");
			System.out.println("�����û���");
			System.out.println("��������");
			System.out.println(
					"��������:" + 
					Integer.parseInt("a")
					);
		}catch(Exception e){
			throw new RuntimeException("������");
		}finally{
			System.out.println("�����ݿ�Ͽ�����");
		}
	}
}




