package day04;

public class Demo07 {
	public static void main(String[] args) {
		for(int n=2; n<=100; n++){
			// n = 2 3 4 ... 100
			//int n = 55;// 53;
			boolean isPrime = true;
			for(int i=2; i<=n/2 ; i++ ){
				//i = 2 3 4 5 6 7 ... n/2
				//System.out.print(i+" "); 
				if(n%i==0){//检查i是否是n的约数
					isPrime = false;//找到约数n不是质数
					break;//如果发现约数就不再查找了
				}
			}
			if(isPrime){
				System.out.println(n+"是质数"); 
			}
		}//for(n) 结束
	}

}
