package day05;
/**
 * ·½·¨ 
 */
public class Demo07 {
	public static void main(String[] args) {
		System.out.println(f(8));//21
		System.out.println(
				(double)f(48)/f(49));//0
	}
	public static long f(int n){
		long f1=1,f2=1,fn=1;
		for(int i=3; i<=n; i++){
			fn = f1+f2;
			f1=f2;
			f2=fn;
		}
		return fn;
	}
}
