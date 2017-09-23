package day04;
/**
 * 抽象类 
 */
public class Demo03 {
	public static void main(String[] args) {
		//Tetromino t = new Tetromint();//
		Tetromino t = new T();
		//不应该直接new Tetromino，
		//因为 Tetromino 没有初始化格子
		t.drop();
	}
}
class T extends Tetromino{
	public T() {
		cells[0] = new Cell(0,4);
		cells[1] = new Cell(0,3);
		cells[2] = new Cell(0,5);
		cells[3] = new Cell(1,4);
	}
}
//使用abstract 在语法上限制new Tetromino
abstract class Tetromino{
	Cell[] cells = new Cell[4];//{^,^,^,^}
	public void drop(){
		cells[0].row++;cells[1].row++;
		cells[2].row++;cells[3].row++;
	}
}
class Cell{
	int row, col;
	public Cell(int row, int col) {
		this.row=row; this.col=col;
	}
}







