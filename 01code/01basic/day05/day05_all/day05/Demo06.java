package day05;
/**
 * 方法的演示 
 */
public class Demo06 {
	public static void main(String[] args) {
		//方法的调用
		boolean hit=hit(96,250,38/2,83,262);
		System.out.println(hit);//true
		System.out.println(
				hit(96,250,38/2,266,334));//false
	}
	public static boolean hit(//在Demo06类体中添加方法
			int x,int y,int r,int x1,int y1){
		//方法体：计算过程
		int a = x1-x;
		int b = y1-y;
		double c = Math.sqrt(a*a + b*b);
		return c<r;//返回计算结果
	}
}




