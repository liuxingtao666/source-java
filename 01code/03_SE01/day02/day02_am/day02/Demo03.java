package day02;

import java.util.Arrays;

/** 
 * 字符串拆分操作 
 */
public class Demo03 {
	public static void main(String[] args) {
		String t = "0,4|0,3|0,5|1,4";
		//将字符串t拆分为一个字符串数组 data
		String[] data = t.split("\\|");// \|
		//data = {"0,4","0,3","0,5","1,4"}
		System.out.println("data："+Arrays.toString(data));
		Cell[] cells = new Cell[4];//{^,^,^,^}
		int i=0;
		for(String s: data){
			//s = "0,4"
			String[] ss = s.split(",");//{"0","4"}
			//Integer.parseInt方法将数字字符串转数字
			// 如：Integer.parseInt("66") 得到 int 66
			int row = Integer.parseInt(ss[0]);
			int col = Integer.parseInt(ss[1]);
			Cell cell = new Cell(row, col);
			cells[i++] = cell;
		}
		System.out.println("cells:"+Arrays.toString(cells));  
	}
}
class Cell{
	int row, col;
	public Cell(int row, int col) {
		this.row = row;	this.col = col;
	}
	public String toString() {
		return "("+row+","+col+")";
	}
}






