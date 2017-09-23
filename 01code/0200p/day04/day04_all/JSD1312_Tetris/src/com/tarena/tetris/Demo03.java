package com.tarena.tetris;

import java.util.Arrays;

public class Demo03 {
	public static void main(String[] args) {
		Cell[][] wall = new Cell[20][10];
		wall[19][3] = new Cell(19,3,null);
		for(int row=0; row<wall.length; row++){
			//row = 0 1 2 ... 19
			//line ����wall�е�ÿһ�� 
			Cell[] line = wall[row];
			for(int col=0; col<line.length; col++){
				//col = 0 1 2 ... 9
				//cell ����ÿ���е�ÿ����(ÿ������)
				Cell cell = line[col];
				System.out.print(cell+",");
			}
			System.out.println();
		}
		//��ȥ19��
		for(int i=19; i>=1; i--){
			//i = 19 18 ... 1
			//��ǰһ�и��Ƶ���ǰ��
			System.arraycopy(wall[i-1], 0, wall[i], 0, 10);
		}
		Arrays.fill(wall[0], null);
		//��ʾһ��, ��ȥ�Ժ�����
		for(int row=0; row<wall.length; row++){
			System.out.println(Arrays.toString(wall[row]));
		}
	}
}







