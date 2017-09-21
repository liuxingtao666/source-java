package day01;

import java.math.BigInteger;

public class Demo04 {
	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");
		String s3 = new String("Abc");
		BigInteger n1 = new BigInteger("5");
		BigInteger n2 = new BigInteger("5");
		BigInteger n3 = new BigInteger("6");
		System.out.println(s1==s2);//false
		System.out.println(s1.equals(s2));//true
		System.out.println(s1.equals(s3));//false
		System.out.println(n1.equals(n2));//true
		System.out.println(n1.equals(n3));//false
		System.out.println(n1.hashCode());
	}
}
