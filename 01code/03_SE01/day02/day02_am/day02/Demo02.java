package day02;
/**
 * �ַ������滻���� 
 */
public class Demo02 {
	public static void main(String[] args) {
		String str = "��һ����ȥ�����ң�" +
				"��˵:���˸�ȥ";
		String s = str.replaceAll(
				"(��[ȥ��])|(���˸�ȥ)", "XX");
		System.out.println(s); 
	}

}
