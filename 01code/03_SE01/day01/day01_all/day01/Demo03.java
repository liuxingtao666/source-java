package day01;
/**
 * equals ���� 
 */
public class Demo03 {
	public static void main(String[] args) {
		Point p1 = new Point(3,4);
		Point p2 = p1;
		Point p3 = new Point(3,4);
		System.out.println(p1==p2);//true
		System.out.println(p1==p3);//false
		//==�Ƚϵ��Ǳ�����ֱ��ֵ���������ڱȽ϶������
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
	/** ��дequals���������������ж��Ƿ���� */
	public boolean equals(Object obj){
		//this obj ��x,y���Զ���Ⱦ���Ϊһ����
		if(obj==null){
			return false;
		}
		if(this == obj){//��ͬһ������ʱ��
			return true;
		}
		// obj->"3,4"
		//���obj���õĶ����Ƿ���Point����
		if(obj instanceof Point){
			Point other = (Point)obj;
			return this.x==other.x && this.y==other.y;
		}
		return false;
	}
	/** һͬ��д hashCode */
	@Override
	public int hashCode() {
		return x*10000+y;
	}
}



