package day02;
/**
 * StringBuilder
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		StringBuilder buf = new StringBuilder();
		buf.append("HI").append("����")
			.append("�ټ�").insert(4, "����˭")
			.delete(7, 7+2);
		//��������toString ת��Ϊ�ַ���
		String str = buf.toString();
		System.out.println(str); 
	}
}
