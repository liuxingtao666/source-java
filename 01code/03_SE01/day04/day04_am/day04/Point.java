package day03;
/**
 * ÓÃÓÚ²âÊÔ·ºĞÍ
 * @author Administrator
 *
 */
public class Point<X,Y> {
	private X x;
	private Y y;
	public Point(X x, Y y) {
		super();
		this.x = x;
		this.y = y;
	}
	public X getX() {
		return x;
	}
	public void setX(X x) {
		this.x = x;
	}
	public Y getY() {
		return y;
	}
	public void setY(Y y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
