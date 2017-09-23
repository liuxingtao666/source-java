package com.tarena.tetris;
/**
 * 2维数组: 元素是数组的数组
 *  java中是本质上没有2维数组, 只有1维数组 
 */
public class Demo02 {
	public static void main(String[] args) {
		Cell[] line1 = new Cell[4];
		line1[0] = new Cell(0,0,null);
		line1[1] = new Cell(0,1,null);
		line1[2] = new Cell(0,2,null);
		line1[3] = new Cell(0,3,null);
		
		Cell[] line2 = new Cell[4];
		line2[0] = new Cell(1,0,null);
		line2[1] = new Cell(1,1,null);
		line2[2] = new Cell(1,2,null);
		line2[3] = new Cell(1,3,null);
		
		Cell[] line3 = new Cell[4];
		line3[0] = new Cell(2,0,null);
		line3[1] = new Cell(2,1,null);
		line3[2] = new Cell(2,2,null);
		line3[3] = new Cell(2,3,null);
		//元素是一维数组的一维数组
		Cell[][] wall = new Cell[][]{line1, line2, line3};
		
	}

}













