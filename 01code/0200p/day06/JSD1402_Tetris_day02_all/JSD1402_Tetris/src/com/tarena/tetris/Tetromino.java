package com.tarena.tetris;

import java.util.Arrays;
import java.util.Random;

/**
 * 4�񷽿��� 
 *
 */
public abstract class Tetromino {
	/** 4�����ӣ���������ʹ�õ����� protected*/
	protected Cell[] cells = new Cell[4];
	/** �������7�ַ���֮һ */
	public static Tetromino randomOne(){
		Random random = new Random(); 
		int type = 0;//random.nextInt(7);
		switch (type) {
		case 0: return new T();
		case 1: return new S();
		case 2: return new Z();
		case 3: return new I();
		case 4: return new L();
		case 5: return new J();
		case 6: return new O();
		}
		return null;
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
	/** �洢��ת״̬���࣬��Tetromino������� */
	protected class State{
		int row0,col0,row1,col1,
		    row2,col2,row3,col3;
		public State(int row0, int col0, int row1, int col1, int row2,
				int col2, int row3, int col3) {
			this.row0=row0;this.col0=col0;
			this.row1 = row1;this.col1 = col1;
			this.row2 = row2;this.col2 = col2;
			this.row3 = row3;this.col3 = col3;
		}
	}
	//��Tetromino �����������ת�ķ���
	private int index = 10000;
	//s0={row0,col0,row1,col1,row2,col2,row3,col3}
	protected State[] states;//�����๹�����г�ʼ�� //{s0,s1,s2,s3};
	public void rotateRight() {
		//����1��cells ��ǰ���������
		//����2��sN : s1 s2 s3 s0 s1 s2 s3 ...
		//��� cells ��ת�Ժ�ķ�������
		//�㷨��cells[0]+sN -> cells
		//��εõ����У�1 2 3 0 1 2 3 0 1 2 3 0
		index ++;//10005
		//index%4 = ?;//1 2 3 0 1 2 3 0 
		//states[index%4]=?//s1 s2 s3 s0 s1 s2 s3...
		State s = states[index%states.length];
		//s = s1
		Cell o = cells[0];//�ҵ��� t0[0]
		int row = o.getRow();
		int col = o.getCol();
		cells[1].setRow(row + s.row1);//���row+s1[row1]=t1.row
		cells[1].setCol(col + s.col1);
		cells[2].setRow(row + s.row2);
		cells[2].setCol(col + s.col2);
		cells[3].setRow(row + s.row3);
		cells[3].setCol(col + s.col3);
	}
	public void rotateLeft() {
		index --;//10005
		State s = states[index%states.length];
		Cell o = cells[0];//�ҵ��� t0[0]
		int row = o.getRow();
		int col = o.getCol();
		cells[1].setRow(row + s.row1);//���row+s1[row1]=t1.row
		cells[1].setCol(col + s.col1);
		cells[2].setRow(row + s.row2);
		cells[2].setCol(col + s.col2);
		cells[3].setRow(row + s.row3);
		cells[3].setCol(col + s.col3);
	}
}
/** T �ͷ��飬������ */
class T extends Tetromino{
	public T() {
		cells[0] = new Cell(0,4,Tetris.T);
		cells[1] = new Cell(0,3,Tetris.T);
		cells[2] = new Cell(0,5,Tetris.T);
		cells[3] = new Cell(1,4,Tetris.T);
		//�������г�ʼ����ת״̬����
		states = new State[]{
			new State(0,0, 0,-1, 0,1, 1,0), //s0
			new State(0,0, -1,0, 1,0, 0,-1),//s1
			new State(0,0, 0,1, 0,-1, -1,0),//s2
			new State(0,0, 1,0, -1,0, 0,1)//s3
		}; 
	}
}
class S extends Tetromino{
	public S() {
		cells[0] = new Cell(0,4,Tetris.S);
		cells[1] = new Cell(0,5,Tetris.S);
		cells[2] = new Cell(1,3,Tetris.S);
		cells[3] = new Cell(1,4,Tetris.S);
	}
}
class L extends Tetromino{
	public L() {
		cells[0] = new Cell(0,4,Tetris.L);
		cells[1] = new Cell(0,3,Tetris.L);
		cells[2] = new Cell(0,5,Tetris.L);
		cells[3] = new Cell(1,3,Tetris.L);
	}
}
class J extends Tetromino{
	public J() {
		cells[0] = new Cell(0,4,Tetris.J);
		cells[1] = new Cell(0,3,Tetris.J);
		cells[2] = new Cell(0,5,Tetris.J);
		cells[3] = new Cell(1,5,Tetris.J);
	}
}
class Z extends Tetromino{
	public Z() {
		cells[0] = new Cell(1,4,Tetris.Z);
		cells[1] = new Cell(1,5,Tetris.Z);
		cells[2] = new Cell(0,3,Tetris.Z);
		cells[3] = new Cell(0,4,Tetris.Z);
	}
}
class O extends Tetromino{
	public O() {
		cells[0] = new Cell(0,4,Tetris.O);
		cells[1] = new Cell(0,5,Tetris.O);
		cells[2] = new Cell(1,4,Tetris.O);
		cells[3] = new Cell(1,5,Tetris.O);
	}
}
class I extends Tetromino{
	public I() {
		cells[0] = new Cell(0,4,Tetris.I);
		cells[1] = new Cell(0,3,Tetris.I);
		cells[2] = new Cell(0,5,Tetris.I);
		cells[3] = new Cell(0,6,Tetris.I);
	}
}




