package day05;
/**
 * ��������ʾ 
 */
public class Demo06 {
	public static void main(String[] args) {
		//�����ĵ���
		boolean hit=hit(96,250,38/2,83,262);
		System.out.println(hit);//true
		System.out.println(
				hit(96,250,38/2,266,334));//false
	}
	public static boolean hit(//��Demo06��������ӷ���
			int x,int y,int r,int x1,int y1){
		//�����壺�������
		int a = x1-x;
		int b = y1-y;
		double c = Math.sqrt(a*a + b*b);
		return c<r;//���ؼ�����
	}
}




