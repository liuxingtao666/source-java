package day06;

import java.util.Arrays;
/**
 * ����䳤�㷨�� 
 */
public class Demo04 {
	public static void main(String[] args) {
		int[] ary = {2,3,4};
		System.out.println(
				Arrays.toString(ary)); 
		//����
		ary=Arrays.copyOf(ary, ary.length+1);
		System.out.println(
				Arrays.toString(ary)); 
		//׷��
		ary[ary.length-1]=9;
		System.out.println(
				Arrays.toString(ary)); 
		//��1Ԫ�������Ԫ�ؽ���
		int t=ary[1];
		ary[1]=ary[ary.length-1];
		ary[ary.length-1]=t;
		//ɾ�����Ԫ��
		ary = Arrays.copyOf(ary,ary.length-1);
		System.out.println(
				Arrays.toString(ary)); 
	}
}
