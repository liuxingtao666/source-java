package day07;
/**
 * ì³²¨ÄÇÆõ ÊýÁÐ
 * f(n) = f(n-1)+f(n-2) ÇÒ f(1)=f(2)=1 
 */
public class Demo03 {
	public static void main(String[] args) {
		System.out.println(f1(50));
		System.out.println(f(50));
	}
	public static long f(int n){
		if(n==1||n==2){return 1;}
		return f(n-1)+f(n-2);
	}
	public static long f1(int n){
		long f1=1,f2=1,fn=1;
		for(int i=3; i<=n; i++){
			fn = f1+f2;
			f1=f2;
			f2=fn;
		}
		return fn; 
	}
}
