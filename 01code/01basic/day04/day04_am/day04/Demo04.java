package day04;

import java.math.BigInteger;

public class Demo04 {
	public static void main(String[] args) {
	    BigInteger n1 = new BigInteger("234");
	    BigInteger n2 = new BigInteger(
	    		"234121212121212122100000");
	    BigInteger n3 = n1.add(n2);
	    System.out.println(n3); 
	}

}
