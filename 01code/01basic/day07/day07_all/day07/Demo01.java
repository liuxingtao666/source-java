package day07;

import java.util.Arrays;

public class Demo01 {
	public static void main(String[] args) {
		int[] ary = {5,3,1,3,6,5,7,8};
		Demo01.sort(ary);
		System.out.println(Arrays.toString(ary));
	}
	public static void sort(int[] ary){
		int i,j,k;
		for(i=1; i<ary.length; i++){
			k = ary[i];//ȡ��iԪ�ص�k
			//j>=0 && ary[j]>k ���Ҳ���λ��
			for(j=i-1; j>=0 && ary[j]>k; j--){
				ary[j+1]=ary[j];//����ƶ�
			}
			ary[j+1] = k;//����k�� j+1
		}
	}
}
