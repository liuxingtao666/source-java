package day02.pm;

import java.util.Arrays;

public class Demo04 {
	public static void main(String[] args) {
		//enemy ����
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
		int del = -1;//�����еķɻ�λ��
		for(int i=0; i<enemies.length; i++){
			//i= 0 1 2 3 4
			//enemy ��[0]ʱ����ը��
			//enemy ��[1]ʱ���Ƿɻ�
			//enemy ��[2]ʱ���Ƿɻ�
			//enemy ��[3]ʱ����ը��
			//enemy������FlyingObject���͵����ñ���
			//�������ڼ�ʵ�����õĶ������͡��ɻ���ը����
			//enemy�������õĶ����Ƕ�����̬��"��̬"
			FlyingObject enemy = enemies[i];
			//������˱���x,y������
			//shootBy �����Ƕ�̬�ģ�
			if(enemy.shootBy(x, y)){
				//�ҵ������еķ��������
				del = i;
				break;
			}
		}
		//����ҵ�ɾ����Ԫ�أ��ͽ��������ɾ��
		if(del!=-1){
			FlyingObject t = enemies[del];
			enemies[del]=enemies[enemies.length-1];
			enemies[enemies.length-1]=t;
			enemies = Arrays.copyOf(
					enemies, enemies.length-1);
		}
		//��ʾɾ���Ľ��
		System.out.println(
				Arrays.toString(enemies));
	}
}
/** �������� */
class FlyingObject{
	int x, y;//���������λ��
	//��ǰ������е� x,y λ����
	public void moveTo(int x, int y){
		this.x = x; this.y=y;
	}
	//��鵱ǰ���������Ƿ��ӵ�(x,y)����
	public boolean shootBy(int x, int y){
		return this.x==x && this.y==y;
	}
}
class Airplane extends FlyingObject{
	int width, height;
	public Airplane(int x, int y, int w, int h){
		//�������п���ʹ��super���ʸ����ж����
		//���Ի򷽷�
		super.x=x;this.y=y;width=w;height=h;
	}
	//�ڷɻ�����д�����м�鷽��
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
	//��д���޸ĸ���ķ��� shootBy
	public boolean shootBy(int x, int y){
		int a = this.x-x;
		int b = this.y-y;
		return Math.sqrt(a*a + b*b)<this.r; 
	}
	public String toString() {
		return x+","+y+","+r;
	}
}







