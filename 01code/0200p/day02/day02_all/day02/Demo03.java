package day02;

import java.util.Arrays;

public class Demo03 {
	public static void main(String[] args) {
		//���ԣ�����̳и�������Ժͷ���
		T t = new T();
		//t.cells �Ǽ̳���Tetromino������
		//System.out.println(t);
		System.out.println(t.toString());
		t.softDrop();//Ҳ�ǴӸ���̳еķ���
		System.out.println(t);
	}
}
class T extends Tetromino{
	public T() {
		cells[0]=new Cell(0,4);
		cells[1]=new Cell(0,3);
		cells[2]=new Cell(0,5);
		cells[3]=new Cell(1,4);
	}
}
class L extends Tetromino{
	public L() {
		cells[0]=new Cell(0,4);
		cells[1]=new Cell(0,3);
		cells[2]=new Cell(0,5);
		cells[3]=new Cell(1,3);
	}
}
/** �ĸ񷽿� ��7�ַ���ĸ�����(super class) */
class Tetromino{
	Cell[] cells=new Cell[4];//{null,null,null,null}
	public void softDrop(){
		for(int i=0; i<cells.length; i++){
			cells[i].drop();
		}
	}
	//... moveLeft moveRight
	public String toString(){
		//return cells[0].toString()+","+
		//       cells[1].toString()+","+
		//       cells[2].toString()+","+
		//       cells[3].toString();
		return Arrays.toString(cells);
	}
}
class Cell{
	int row, col;
	public Cell(int row, int col){
		this.row = row; this.col=col;
	}
	public void drop(){
		row++;
	}
	public void moveLeft(){
		col--;
	}
	public void moveRight(){
		col++;
	}
	
	public String toString(){
		return row+","+col; 
 	}
}









