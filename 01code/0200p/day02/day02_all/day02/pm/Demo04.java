package day02.pm;

import java.util.Arrays;

public class Demo04 {
	public static void main(String[] args) {
		//enemy 敌人
		FlyingObject[] enemies =
			new FlyingObject[5];//{^,^,^,^,^}
		System.out.println(
				Arrays.toString(enemies));
		enemies[0]=new Bomb(199, 89, 25);
		enemies[1]=new Airplane(54,96,78,81);
		enemies[2]=new Airplane(52,231,78,81);
		enemies[3]=new Bomb(192, 219, 25);
		enemies[4]=new Bomb(119, 375, 25);
		int x = 109;
		int y = 163;
		System.out.println(
				Arrays.toString(enemies));
		int del = -1;//被击中的飞机位置
		for(int i=0; i<enemies.length; i++){
			//i= 0 1 2 3 4
			//enemy 当[0]时候，是炸弹
			//enemy 当[1]时候，是飞机
			//enemy 当[2]时候，是飞机
			//enemy 当[3]时候，是炸弹
			//enemy变量是FlyingObject类型的引用变量
			//在运行期间实际引用的对象类型“飞机、炸弹”
			//enemy变量引用的对象是多种形态的"多态"
			FlyingObject enemy = enemies[i];
			//如果敌人被（x,y）击中
			//shootBy 方法是多态的！
			if(enemy.shootBy(x, y)){
				//找到被击中的飞行物序号
				del = i;
				break;
			}
		}
		//如果找到删除的元素，就交换到最后并删除
		if(del!=-1){
			FlyingObject t = enemies[del];
			enemies[del]=enemies[enemies.length-1];
			enemies[enemies.length-1]=t;
			enemies = Arrays.copyOf(
					enemies, enemies.length-1);
		}
		//显示删除的结果
		System.out.println(
				Arrays.toString(enemies));
	}
}
/** 飞行物体 */
class FlyingObject{
	int x, y;//飞行物体的位置
	//当前物体飞行到 x,y 位置上
	public void moveTo(int x, int y){
		this.x = x; this.y=y;
	}
	//检查当前飞行物体是否被子弹(x,y)击中
	public boolean shootBy(int x, int y){
		return this.x==x && this.y==y;
	}
}
class Airplane extends FlyingObject{
	int width, height;
	public Airplane(int x, int y, int w, int h){
		//在子类中可以使用super访问父类中定义的
		//属性或方法
		super.x=x;this.y=y;width=w;height=h;
	}
	//在飞机中重写：击中检查方法
	public boolean shootBy(int x, int y){
		int dx = x-super.x;
		int dy = y-this.y;
		return dx>0&&dx<width && dy>0&&dy<height; 
	}
	public String toString(){
		return x+","+y+","+width+","+height;
	}
}
class Bomb extends FlyingObject{
	int r;
	public Bomb(int x, int y, int r) {
		this.x=x; this.y=y; this.r=r;
	}
	//重写：修改父类的方法 shootBy
	public boolean shootBy(int x, int y){
		int a = this.x-x;
		int b = this.y-y;
		return Math.sqrt(a*a + b*b)<this.r; 
	}
	public String toString() {
		return x+","+y+","+r;
	}
}







