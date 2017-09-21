package day03;

public class TestPoint {
	public static void main(String[] args) {
		//day03.Point.Point(Integer x, Integer y)
		Point<Integer,Integer> p
			= new Point<Integer,Integer>(1,2);
		p.setX(3);
		p.setY(4);
		System.out.println(p);
		
		Point<Double,Double> p1
			= new Point<Double,Double>(1.1,2.2);
		p1.setX(2.3);
		System.out.println(p1);
		
		Point<Integer,Double> p2
			= new Point<Integer,Double>(1,2.2);
		
	}
}
