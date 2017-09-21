package day04;
/**
 * 用于测试可比较性
 * 注意:
 * 	泛型属性不要参与比较。因为前期类型不能确定
 * 
 * 实现可比较性:实现Comparable接口
 * 哪个类实现Comparable接口，那么该接口声明
 * 的泛型类型就是哪个类
 * @author Administrator
 *
 */
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int compareTo(Point o) {
		/*
		 * 比较规则，离原点远的点大
		 * 该方法的返回值:
		 * 不关心取值，只关心范围。
		 * 当返回值>0：当前对象比参数对象大
		 * 当返回值<0：当前对象比参数对象小
		 * 当返回值=0：两个对象相等
		 */
		int r = this.x*this.x + this.y*this.y;
		int ro = o.x * o.x + o.y * o.y;
		return r-ro;
	}
	
	
	public String toString() {
		return "("+x+","+y+")";
	}




	
	
}



