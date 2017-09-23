package day04.pm;

import java.util.Arrays;

public class Demo05 {
	public static void main(String[] args) {
//		Cell[] cells = new Cell[4];
//		cells[0] = new Cell(0,4);
//		cells[1] = new Cell(0,3);
//		cells[2] = new Cell(0,5);
//		cells[3] = new Cell(1,4);
		Cell[] cells = new Cell[]{
				new Cell(0,4),
				new Cell(0,3),
				new Cell(0,5),
				new Cell(1,4)
		};
		System.out.println(
				Arrays.toString(cells));
		
		Cell[] line0 = new Cell[10];
		Cell[] line1 = new Cell[10];
		Cell[] line2 = new Cell[10];
		Cell[] line3 = new Cell[10];
		Cell[] line4 = new Cell[10];
		//元素是数组的数组
		Cell[][] wall = {line0,line1,
				line2,line3,line4};
		Cell[][] wall2 = new Cell[20][10];
		//定义了引用line 引用了20行
		Cell[] line = wall2[19];
		line[2] = new Cell(19,2);
		wall2[18][3]=new Cell(18,3);
		for(int i=0; i<wall2.length; i++){
			//i = 0 1 2 3 ... 19
			line = wall2[i];
			for(int j=0; j<line.length; j++){
				//j=0 1 2 3 9
				Cell cell = line[j];
				System.out.print(cell+" ");
			}
			System.out.println();//回车
		}
		//消除19行
		for(int i=19; i>=1; i--){
			System.arraycopy(wall2[i-1],0, 
					wall2[i], 0, 10);
		}
		Arrays.fill(wall2[0], null);
		//显示
		for(int i=0; i<wall2.length; i++){
			System.out.println(
				Arrays.toString(wall2[i]));
		}
	}
}
class Cell{
	int row, col;
	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	@Override //重写
	public String toString() {
	 	return row+","+col;
	}
}






