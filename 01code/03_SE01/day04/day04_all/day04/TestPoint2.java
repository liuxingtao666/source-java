package day03;


/**
 * ����ԭ��
 * @author Administrator
 *
 */
public class TestPoint2 {
	public static void main(String[] args) {
		/*
		 * ���͵�Ĭ��������Object
		 */
		Point p = new Point(1,2);
		int x = (Integer)p.getX();
		
		/*
		 * ������ָ�����ͺ�
		 * �����ǶԷ���Ҫ������ݸ�ֵʱ:
		 * ����������ݷ��ͼ�������Ƿ�ƥ��
		 */
		Point<Integer,Integer> p1
			= new Point<Integer,Integer>(1,2);
		/*
		 * ȡֵʵ�ڳ��������ڼ�JVM�����
		 * ���������Զ�����ת����
		 */
		int x1 = p1.getX();
		
	}
}
