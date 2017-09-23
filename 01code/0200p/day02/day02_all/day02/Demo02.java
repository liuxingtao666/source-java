package day02;

import java.util.Random;

public class Demo02 {
	public static void main(String[] args) {
		Airplane airplane=new Airplane(50, 55);
		System.out.println(airplane.x);
		System.out.println(airplane.y);
		airplane.move();
		System.out.println(airplane.x);
		System.out.println(airplane.y);
		airplane = null;
		airplane.move();
	}
}
class Airplane{
	int x, y, width, height;
	//给定飞机的位置，创建飞机
	public Airplane(int x, int y, int w, int h){
		this.x = x; this.y=y;
		width = w; height = h;
	}
	//飞机在屏幕外随机位置出场
	public Airplane(int w, int h){
		width = w; height = h;
		y = -h;
		Random random = new Random();
		x = random.nextInt(285-w);
	}
	
	public void move(){
		this.y++;
	}
}




