package day04;

import java.math.BigInteger;

public class Demo05 {
	public static void main(String[] args) {
		//输入：
		int n = 50;
		//输出
		BigInteger s = new BigInteger("1");
		//算法
		for(int i=1; i<=n; i++){
			BigInteger x=new BigInteger(""+i);
			s = s.multiply(x);//s*=i;
		}
		//输出结果
		System.out.println(s); 
	}

}





