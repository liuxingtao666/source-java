package day03.pm;
// ��̬�����
public class Demo08 {
	public static void main(String[] args) {
		Hoo h1 = new Hoo();
		Hoo h2 = new Hoo();
	}
}
class Hoo{
	{//����飬�ڴ�������ʱ��ִ�У�������
		System.out.println("HI");
	}
	static {//�ڼ���Hoo��ʱ��ִ��
		System.out.println("Ye");
	}
}




