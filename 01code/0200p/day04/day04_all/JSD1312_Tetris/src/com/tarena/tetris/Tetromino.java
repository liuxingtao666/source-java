package com.tarena.tetris;

import java.util.Arrays;
import java.util.Random;

/**
 * 4格方块类型, 要想获得Tetromino对象,只能调用randomOne()
 * Tetromino t = Tetromino.randomOne()
 */
public abstract class Tetromino {
	protected Cell[] cells = new Cell[4];
	protected State[] states;
	protected int index = 10000;
	protected class State{
		int row0,col0,row1,col1,row2,col2,row3,col3;
		public State(int row0, int col0, 
				int row1, int col1, int row2, int col2,
				int row3, int col3) {
			super();
			this.row0 = row0;
			this.col0 = col0;
			this.row1 = row1;
			this.col1 = col1;
			this.row2 = row2;
			this.col2 = col2;
			this.row3 = row3;
			this.col3 = col3;
		}
	}
	
	private Tetromino() {	
	}
	/** 在Tetromino 中添加旋转算法
	 * 1) 找到下一个旋转状态数据 Sn
	 * 2) 获取轴的row, col
	 * 3) 将轴的 row  col 分别与 Sn 的数据相加
	 *   作为新状态的 row,col 赋值给格子,
	 *   格子就被计算为新的位置了
	 *  */
	public void rotateRight(){
		//假设T 的初始状态 t0 [04][03][05][14] -> t1
		index++; //10001
		State s = states[index % states.length];//S1
		//s=(0,0, -1,0, 1,0, 0,-1)
		Cell o = cells[0];//找到轴
		int row = o.getRow();//0
		int col = o.getCol();//4
		cells[1].setRow(row + s.row1);//-1
		cells[1].setCol(col + s.col1);//4
		cells[2].setRow(row + s.row2);
		cells[2].setCol(col + s.col2);
		cells[3].setRow(row + s.row3);
		cells[3].setCol(col + s.col3);
		//t1 = [0,4][-1 4][1 4][0 3]
	}
	public void rotateLeft(){
		index--; //10000
		State s = states[index % states.length]; 
		Cell o = cells[0];//找到轴
		int row = o.getRow(); 
		int col = o.getCol(); 
		cells[1].setRow(row + s.row1); 
		cells[1].setCol(col + s.col1); 
		cells[2].setRow(row + s.row2);
		cells[2].setCol(col + s.col2);
		cells[3].setRow(row + s.row3);
		cells[3].setCol(col + s.col3);
	}
	
	public void softDrop(){
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			cell.drop();
		}
	}
	public void moveLeft(){
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			cell.moveLeft();
		}
	}
	public void moveRight(){
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			cell.moveRight();
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(cells); 
	}
	
	public static Tetromino randomOne(){
		Random random = new Random();
		int type = random.nextInt(7);
		switch (type) {
		case 0: return new T();
		case 1: return new I();
		case 2: return new L();
		case 3: return new S();
		case 4: return new Z();
		case 5: return new O();
		case 6: return new J();
		}
		return null;
	}
	private static class T extends Tetromino{
		public T() {
			cells[0] = new Cell(0, 4, Tetris.T);
			cells[1] = new Cell(0, 3, Tetris.T);
			cells[2] = new Cell(0, 5, Tetris.T);
			cells[3] = new Cell(1, 4, Tetris.T);
			states = new State[4];
			states[0] = new State(0,0,0,-1,0,1,1,0);
			states[1] = new State(0,0,-1,0,1,0,0,-1);
			states[2] = new State(0,0,0,1,0,-1,-1,0);
			states[3] = new State(0,0,1,0,-1,0,0,1);
		}
	}
	private static class J extends Tetromino{
		public J() {
			cells[0] = new Cell(0, 4, Tetris.J);
			cells[1] = new Cell(0, 3, Tetris.J);
			cells[2] = new Cell(0, 5, Tetris.J);
			cells[3] = new Cell(1, 5, Tetris.J);
			states = new State[] { 
					new State(0, 0, 0, 1, 0, -1, -1, -1),
					new State(0, 0, 1, 0, -1, 0, -1, 1),
					new State(0, 0, 0, -1, 0, 1, 1, 1),
					new State(0, 0, -1, 0, 1, 0, 1, -1)};
		}
	}
	private static class L extends Tetromino{
		public L() {
			cells[0] = new Cell(0, 4, Tetris.L);
			cells[1] = new Cell(0, 3, Tetris.L);
			cells[2] = new Cell(0, 5, Tetris.L);
			cells[3] = new Cell(1, 3, Tetris.L);
			states = new State[] { 
					new State(0, 0, 0, 1, 0, -1, -1, 1),
					new State(0, 0, 1, 0, -1, 0, 1, 1),
					new State(0, 0, 0, -1, 0, 1, 1, -1),
					new State(0, 0, -1, 0, 1, 0, -1, -1)};
		}
	}
	private static class I extends Tetromino{
		public I() {
			cells[0] = new Cell(0, 4, Tetris.I);
			cells[1] = new Cell(0, 3, Tetris.I);
			cells[2] = new Cell(0, 5, Tetris.I);
			cells[3] = new Cell(0, 6, Tetris.I);
			states = new State[] { 
					new State(0, 0, 0, -1, 0, 1, 0, 2),
					new State(0, 0, -1, 0, 1, 0, 2, 0)};
		}
	}
	private static class S extends Tetromino{
		public S() {
			cells[0] = new Cell(0, 4, Tetris.S);
			cells[1] = new Cell(0, 5, Tetris.S);
			cells[2] = new Cell(1, 3, Tetris.S);
			cells[3] = new Cell(1, 4, Tetris.S);
			states = new State[] { 
					new State(0, 0, 0, 1, 1, -1, 1, 0),
					new State(0, 0, -1, 0, 1, 1, 0, 1)};
		}
	}
	private static class Z extends Tetromino{
		public Z() {
			cells[0] = new Cell(1, 4, Tetris.Z);
			cells[1] = new Cell(0, 3, Tetris.Z);
			cells[2] = new Cell(0, 4, Tetris.Z);
			cells[3] = new Cell(1, 5, Tetris.Z);
			states = new State[] { 
					new State(0, 0, -1, -1, -1, 0, 0, 1),
					new State(0, 0, -1, 1, 0, 1, 1, 0)};
		}
	}
	private static class O extends Tetromino{
		public O() {
			cells[0] = new Cell(0, 4,  Tetris.O);
			cells[1] = new Cell(0, 5,  Tetris.O);
			cells[2] = new Cell(1, 4,  Tetris.O);
			cells[3] = new Cell(1, 5,  Tetris.O);
			states = new State[] { new State(0, 0, 0, 1, 1, 0, 1, 1),
					new State(0, 0, 0, 1, 1, 0, 1, 1) };
		}
	}


}
//?
//class T extends Tetromino{}//不能访问 私有构造器
