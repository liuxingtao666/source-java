package day07;
/**
 *f(n) = 1+2+3+...+n = n+f(n-1) 并且 f(1)=1
  f(n) = n+f(n-1) 并且 f(1)=1 称为递归定义
 */
public class Demo02 {
	public static void main(String[] args) {               
		int n = 50000;
		int y = f(n);
		System.out.println(y); 
	}
	public static int f(int n){
		if(n==1){//递归结束条件
			return 1;
		}//     递归调用
		return n + f(n-1);
	}
}
