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
			k = ary[i];//取出i元素到k
			//j>=0 && ary[j]>k 查找插入位置
			for(j=i-1; j>=0 && ary[j]>k; j--){
				ary[j+1]=ary[j];//向后移动
			}
			ary[j+1] = k;//插入k到 j+1
		}
	}
}
