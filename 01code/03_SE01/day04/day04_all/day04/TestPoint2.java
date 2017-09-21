package day03;


/**
 * 泛型原理
 * @author Administrator
 *
 */
public class TestPoint2 {
	public static void main(String[] args) {
		/*
		 * 泛型的默认类型是Object
		 */
		Point p = new Point(1,2);
		int x = (Integer)p.getX();
		
		/*
		 * 当我们指定泛型后
		 * 当我们对泛型要求的内容赋值时:
		 * 编译器会根据泛型检查类型是否匹配
		 */
		Point<Integer,Integer> p1
			= new Point<Integer,Integer>(1,2);
		/*
		 * 取值实在程序运行期间JVM会根据
		 * 泛型来做自动类型转换。
		 */
		int x1 = p1.getX();
		
	}
}
