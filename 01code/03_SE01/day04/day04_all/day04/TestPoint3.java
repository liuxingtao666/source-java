package day03;
/**
 * ���͵�ע������
 * @author Administrator
 *
 */
public class TestPoint3 {
	public static void main(String[] args) {
		
		Point<Integer,Integer> p
			= new Point<Integer,Integer>(1,2);
		//jvm֪��XӦ��ʹ��ʲô����
//		p.setX("");//���벻ͨ��
		p.setX(1);
		
		Point p2 = p;
		p2.setX("1");
		
		String x = (String)p2.getX();
		System.out.println(x);
		
		int xx = p.getX();//ClassCastException
		
		
	}
}




