package day04;

import java.math.BigInteger;

public class Demo05 {
	public static void main(String[] args) {
		//���룺
		int n = 50;
		//���
		BigInteger s = new BigInteger("1");
		//�㷨
		for(int i=1; i<=n; i++){
			BigInteger x=new BigInteger(""+i);
			s = s.multiply(x);//s*=i;
		}
		//������
		System.out.println(s); 
	}

}





