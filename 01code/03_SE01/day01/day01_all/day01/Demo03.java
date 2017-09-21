package day01;
/**
 * equals 方法 
 */
public class Demo03 {
	public static void main(String[] args) {
		Point p1 = new Point(3,4);
		Point p2 = p1;
		Point p3 = new Point(3,4);
		System.out.println(p1==p2);//true
		System.out.println(p1==p3);//false
		//==比较的是变量的直接值，不能用于比较对象相等
		System.out.println(p1.equals(p3));//true
		System.out.println(p1.equals("3,4"));//false
		System.out.println(p1.equals(null)); //false
	}
}
class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;	this.y = y;
	}
	/** 重写equals方法，根据属性判断是否相等 */
	public boolean equals(Object obj){
		//this obj 的x,y属性都相等就认为一样了
		if(obj==null){
			return false;
		}
		if(this == obj){//是同一个对象时候
			return true;
		}
		// obj->"3,4"
		//检查obj引用的对象是否是Point类型
		if(obj instanceof Point){
			Point other = (Point)obj;
			return this.x==other.x && this.y==other.y;
		}
		return false;
	}
	/** 一同重写 hashCode */
	@Override
	public int hashCode() {
		return x*10000+y;
	}
}



