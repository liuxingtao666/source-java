package day06;

public class Demo01 {
	public static void main(String[] args) {
		int a = get(new int[] { 2, 3, 4 });
		a = get(new int[3]);
		//a = get(null);
		a = get(new int[1]);//�����쳣
	}
	public static int get(int[] ary) {
		//ary�����������ڼ��Ⱥ������˲�ͬ������
		//Java�������ǲ���ȷ�������ĸ������
		// ������ȷ������ĳ���
		//����Java����������ȷ������Խ���Ǳ������
		// ary �ĳ��ȣ�
		// ary ��[1]Ԫ����
		return ary[1];
	}
}
