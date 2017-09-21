package day03;
/**
 * 泛型的注意事项
 * @author Administrator
 *
 */
public class TestPoint3 {
	public static void main(String[] args) {
		
		Point<Integer,Integer> p
			= new Point<Integer,Integer>(1,2);
		//jvm知道X应该使用什么类型
//		p.setX("");//编译不通过
		p.setX(1);
		
		Point p2 = p;
		p2.setX("1");
		
		String x = (String)p2.getX();
		System.out.println(x);
		
		int xx = p.getX();//ClassCastException
		
		
	}
}




