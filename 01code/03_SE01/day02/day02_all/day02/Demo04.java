package day02;
/**
 * ���һ���ַ����Ƿ���� ��������� 
 */
public class Demo04 {
	public static void main(String[] args) {
		String str = "0,4|0,3|0,5|1,4";
		//ע�� \ ��Ҫת��Ϊ \\
		String rule = "^(\\d,\\d\\|){3}\\d,\\d$";
		//rule:����
		//���str����rule������������
		boolean pass = str.matches(rule);
		System.out.println(pass);//true
	}

}
