package day02;
/**
 * �������ڲ��Լ��ϡ���Ϊ���ϵ�Ԫ�ش���
 * @author Administrator
 *
 */
public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	/**
	 * (1,2)
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point){
			Point p = (Point)obj;
			return this.x==p.x && this.y == p.y;
		}
		return false;
	}
}
