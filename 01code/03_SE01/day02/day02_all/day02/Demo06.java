package day02;
/**
 * StringBuilder
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		StringBuilder buf = new StringBuilder();
		//append ׷�ӣ���StringBuilder����׷���ַ�����
		buf.append("�������һ��ţx����");
		//          0 1 2 3 4 5 6 7 89 10
		buf.replace(2, 4, "��ʦ");//�滻�ַ�
		System.out.println(buf);//Ĭ�ϵ���toString
	}
}


