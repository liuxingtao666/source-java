package com.tarena.tetris;

import java.util.Arrays;

/**
 * �������� 
 */
public class Demo01 {
	public static void main(String[] args) {
		//��������, Ԫ���Ƕ���
		//����������ʵ�ʱ������ 4�� ����
		Cell[] cells = new Cell[4];
		System.out.println(cells);
		cells[0] = new Cell(0,3,null);
		cells[1] = new Cell(0,4,null);
		cells[2] = new Cell(0,5,null);
		cells[3] = new Cell(1,4,null);
		System.out.println(Arrays.toString(cells));
	}
}
//class Cell{
//	



//}


