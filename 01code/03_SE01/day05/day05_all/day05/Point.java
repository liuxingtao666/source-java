package day04;
/**
 * ���ڲ��ԿɱȽ���
 * ע��:
 * 	�������Բ�Ҫ����Ƚϡ���Ϊǰ�����Ͳ���ȷ��
 * 
 * ʵ�ֿɱȽ���:ʵ��Comparable�ӿ�
 * �ĸ���ʵ��Comparable�ӿڣ���ô�ýӿ�����
 * �ķ������;����ĸ���
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
		 * �ȽϹ�����ԭ��Զ�ĵ��
		 * �÷����ķ���ֵ:
		 * ������ȡֵ��ֻ���ķ�Χ��
		 * ������ֵ>0����ǰ����Ȳ��������
		 * ������ֵ<0����ǰ����Ȳ�������С
		 * ������ֵ=0�������������
		 */
		int r = this.x*this.x + this.y*this.y;
		int ro = o.x * o.x + o.y * o.y;
		return r-ro;
	}
	
	
	public String toString() {
		return "("+x+","+y+")";
	}




	
	
}



