package com.tarena.tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ����˹����
 *
 */
public class Tetris extends JPanel {
	/** ��Ϸ��״̬ */
	private int state;
	/** ��Ϸ������״̬ */
	public static final int PLAYING = 0;
	/** ��Ϸ��ͣ״̬ */
	public static final int PAUSE = 1;
	/** ��Ϸ����״̬ */
	public static final int GAME_OVER = 2;
	/** ��Ϸ״̬��ʾ��Ϣ */
	private static final String[] STATE=
	  {"[P]Pause", "[C]Continue", "[S]Restart"};
	/** �����ٶȿ��� */
	int index = 0;  
	/** speed ��ֵԽС�����ٶ�Խ�� */
	int speed = 8; 
	
	/** ���� */
	private int score;
	/** ������ ���ٵ������� */
	private int lines;
	public static final int ROWS = 20;
	public static final int COLS = 10;
	/** ����ǽ */
	private Cell[][] wall=new Cell[ROWS][COLS];
	/** ��������ķ��� */
	private Tetromino tetromino;
	/** ��һ������ */
	private Tetromino nextOne;
	
	/** ��Tetris ����ӱ���ͼ���� */
	private static BufferedImage background;
	public static BufferedImage gameOverImage;
	public static BufferedImage T;
	public static BufferedImage S;
	public static BufferedImage Z;
	public static BufferedImage J;
	public static BufferedImage L;
	public static BufferedImage I;
	public static BufferedImage O;
	
	/** ��ȡͼƬ�ļ����ڴ���� */
	//��ͼƬ���Ƶ� com.tarena.tetris����
	static {
		try{
			background=ImageIO.read(
				Tetris.class.getResource(
						"tetris.png"));
			gameOverImage=ImageIO.read(
					Tetris.class.getResource(
							"game-over.png"));
			T=ImageIO.read(Tetris.class
					.getResource("T.png"));
			S=ImageIO.read(Tetris.class
					.getResource("S.png"));
			Z=ImageIO.read(Tetris.class
					.getResource("Z.png"));
			J=ImageIO.read(Tetris.class
					.getResource("J.png"));
			L=ImageIO.read(Tetris.class
					.getResource("L.png"));
			O=ImageIO.read(Tetris.class
					.getResource("O.png"));
			I=ImageIO.read(Tetris.class
					.getResource("I.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/** ������д�����޸ĸ���JPanel */
	//paint:Ϳ�棬 Graphics��ͼ������
	public void paint(Graphics g){
		//draw: ��
		g.drawImage(background, 0, 0, null);
		//g.drawString("Hello", 50, 50);
		g.translate(15, 15);
		paintWall(g);
		paintTetromino(g);
		paintNextOne(g);
		paintScore(g);//���Ʒ���
		g.translate(-15, -15);
		paintState(g);//������Ϸ״̬
	}
	//����״̬
	private void paintState(Graphics g) {
		//���state�� 0 ��ʾ Pause 
		//���state�� 1 ��ʾ Continue
		//���state�� 2 ��ʾ Restart
		g.drawString(STATE[state], 309, 287);
		if(state == GAME_OVER){
			g.drawImage(gameOverImage,0,0,null);
		}
	}
	//���Ʒ���
	private void paintScore(Graphics g){
		int x = 293; 
		int y = 162;
		Font font = new Font(
				Font.SANS_SERIF, Font.BOLD, 30);
		g.setFont(font);
		g.setColor(new Color(0x667799)); 
		g.drawString("SCORE:"+score, x, y);
		y+=56;
		g.drawString("LINES:"+lines, x, y);
	}
	
	public void paintNextOne(Graphics g){
		Cell[] cells = nextOne.cells;
		for(int i=0;i<cells.length; i++){
			Cell cell = cells[i];
			int x = CELL_SIZE*(cell.getCol()+10);
			int y = CELL_SIZE*(cell.getRow()+1);
			g.drawImage(cell.getImage(), x, y,
					null);
		}
	}
	/** ��Tetris�������,������������ķ��� */
	public void paintTetromino(Graphics g){
		Cell[] cells = tetromino.cells;
		for(int i=0;i<cells.length; i++){
			Cell cell = cells[i];
			int x = CELL_SIZE*cell.getCol();
			int y = CELL_SIZE*cell.getRow();
			g.drawImage(cell.getImage(), x, y,
					null);
		}
	}
	public static final int CELL_SIZE=26;
	/** ��Tetris ��ӻ�ǽ�ķ��� */
	private void paintWall(Graphics g){
		for(int row=0; row<ROWS; row++){
			for(int col=0; col<COLS; col++){
				Cell cell = wall[row][col];
				int x=CELL_SIZE * col;
				int y=CELL_SIZE * row;
				if(cell==null){
					//g.drawRect(x, y, 
					//	CELL_SIZE, CELL_SIZE);
				}else{
					g.drawImage(cell.getImage(),
							x,y,null);
				}
			}
		}
	}
	
	/** ��Tetris ������ӷ��� */
	public void action(){
		state = PLAYING;
		//wall[19][2]=new Cell(19,2,T);
		//����ĵ���paint()���»������
		tetromino = Tetromino.randomOne();
		nextOne = Tetromino.randomOne();
		repaint();
		//���������¼�����������
		KeyListener l=new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				//��state��ֵ��PAUSEʱ��ֻ����c����
				//�����İ����Ĵ��뱻���Բ���ִ��
				if(key==KeyEvent.VK_Q){
					System.exit(0);//����Java����
				}
				switch(state){
				case GAME_OVER:
					if(key==KeyEvent.VK_S){
						restartAction(); 
					}
					return;
				case PAUSE:
					if(key==KeyEvent.VK_C){
						state=PLAYING;
					}
					//retuer�Ժ�Ĵ��벻��ִ����
					return;
				}
				switch(key){
				case KeyEvent.VK_DOWN:
					softDropAction();break;
				case KeyEvent.VK_RIGHT:
					moveRightAction();break;
				case KeyEvent.VK_LEFT:
					moveLeftAction();	break;
				case KeyEvent.VK_UP:
					rotateRightAction(); break;
				case KeyEvent.VK_Z:
					rotateLeftAction(); break;
				case KeyEvent.VK_SPACE:
					hardDropAction();	break;
				case KeyEvent.VK_P: 
					state = PAUSE; break;
				}
				repaint();
			}
		};
		//��Ӽ���������ǰ��壨���أ�
		this.addKeyListener(l);
		//Ϊ��ǰ����������뽹�㣬�н�����ܽ��ռ����¼�
		this.requestFocus();
		
		//��action��������ӣ�������ѭ��
		for(;;){
			if(state==PLAYING){
				index ++;
				if(index % speed==0){
					softDropAction();
				}
			}
			repaint();
			try{
				Thread.sleep(1000/10);
			}catch(Exception e){
			}
		}
	}
	/** ���¿�ʼ��Ϸ */
	protected void restartAction() {
		score = 0;
		lines = 0;
		//��ǽ���
		wall = new Cell[ROWS][COLS];
		tetromino = Tetromino.randomOne();
		nextOne = Tetromino.randomOne();
		speed = 8;
		index = 0;
		state = PLAYING;
	}
	/** ��Tetris������Ӽ�����������
	 * �������䵽��������Ϊֹ 
	 **/
	private void hardDropAction(){
		//���ܹ����������һ��������������Ϊֹ
		while(canDrop()){
			tetromino.softDrop();
		}
		landIntoWall();
		destroyLines();
		if(!isGameOver()){
			tetromino = nextOne;
			nextOne = Tetromino.randomOne();
		}else{ //��Ϸ����״̬
			state = GAME_OVER;
		}
	}
	
	/** ��Tetris ������д���� softDropAction */
	private void softDropAction(){
		boolean drop = canDrop();
		//System.out.println("t:"+tetromino); 
		//System.out.println("canDrop:"+drop); 
		if(drop){
			tetromino.softDrop();
		}else{
			// ��ǽ,land��½ into��ȥ Wall ǽ
			landIntoWall();//��װ ������ǽ ���㷨
			// ������ destroyLines���Ʒ�
			destroyLines();//��װ�����е��㷨
			// ����Ƿ����
			// �����Ϸû�н�����������һ������
			if(!isGameOver()){
				tetromino=nextOne;
				nextOne=Tetromino.randomOne();
			}else{
				state = GAME_OVER;
			}
		}
		//System.out.println(tetromino); 
	}
	/** �����Ϸ�Ƿ����
	 * �����һ����Ҫ�����ķ����ǽ��λ�ñ�ռ��
	 * �˾ͽ����ˣ�
	 *  */
	private boolean isGameOver() {
		Cell[] cells = nextOne.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row=cell.getRow();
			int col=cell.getCol();
			if(wall[row][col]!=null){
				return true;
			}
		}
		return false;
	}
	
	/** ����ǽ���Ѿ�������, ���ҼƷ� */
	private int[] scoreTable = {0,1,5,20,100};
	//               lines      0 1 2  3  4
	private void destroyLines() {
		int lines = 0;//��ǰ���ٵ�����
		for(int row=0; row<ROWS; row++){
			if(fullCells(row)){
				deleteRow(row);
				lines++;
			}
		}
		this.score += scoreTable[lines];
		//�ٶȿ��ƣ�ÿ����1000��ʱ���ٶ�
		//��ֵ���С���ٶȼӿ�
		//�ٶȵ���Сֵ�� 1�����ܱ�1��С��
		speed = Math.max(8-score/1000, 1);
		this.lines += lines;
	}
	/** ���ǽ��row���Ƿ���"������"��true������ */
	private boolean fullCells(int row) {
		Cell[] line = wall[row];
		for(int i=0; i<line.length; i++){
			Cell cell = line[i];
			if(cell==null){
				return false;
			}
		}
		return true;
	}
	/** ɾ��ǽ�� row��Ӧ���� */
	private void deleteRow(int row) {
		for(int i=row; i>=1; i--){
			System.arraycopy(wall[i-1], 0, 
					wall[i], 0, COLS);
		}
		Arrays.fill(wall[0], null);
	}
	/** ��������½��ǽ�� */
	private void landIntoWall() {
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col]=cell;
		}
	}
	/** ��Tetris������ӷ��� canDrop() */
	private boolean canDrop(){
		//������ wall tetromino 
		//�ȼ��tetromino�Ƿ񵽴�ײ�
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			//i = 0 1 2 3 
			//cell�����á���4�񷽿��ÿ����ʽ
			Cell cell = cells[i];
			//���ĳ�����ӵ�����19���Ͳ���������
			if(cell.getRow() == ROWS-1){
				//System.out.println("����ײ�");
				return false;
			}
		}
		
		//���tetromino���·�ǽ���Ƿ��з���
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if(wall[row+1][col]!=null){
				//System.out.println(cell+"���·��з���");
				return false;
			}
		}
		return true;
	}
	
	/** Tetris ������������ƶ����̿��Ʒ��� */
	private void moveRightAction(){
		tetromino.moveRight();
		//outOfBounds���� concide���غ�
		if(outOfBounds() || concide()){
			tetromino.moveLeft();
		}
	}
	private void moveLeftAction(){
		tetromino.moveLeft();
		//outOfBounds���� concide���غ�
		if(outOfBounds() || concide()){
			tetromino.moveRight();
		}
	}
	//��鵱ǰ����ķ��飬�Ƿ���磬true��������
	private boolean outOfBounds(){
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if((row<0||row>=ROWS) ||
					(col<0||col>=COLS)){
				return true;
			}
		}
		return false;
	}
	//��鵱ǰ����ķ��飬�Ƿ���ǽש�غϣ�true�غ�
	private boolean concide(){
		Cell[] cells = tetromino.cells;
		//for (int i = 0; i < cells.length; i++) {
		//	Cell cell = cells[i];
		for(Cell cell: cells){
			int row = cell.getRow();
			int col = cell.getCol();
			if(wall[row][col]!=null){
				return true;
			}
		}
		return false;
	}
	/** ��tetris ����������ת���̿��Ʒ��� */
	public void rotateRightAction(){
		//rotate:ԭ��ת
		tetromino.rotateRight();
		if(outOfBounds() || concide()){
			tetromino.rotateLeft();
		}
	}
	public void rotateLeftAction(){
		//rotate:ԭ��ת
		tetromino.rotateLeft();
		if(outOfBounds() || concide()){
			tetromino.rotateRight();
		}
	}
	
	public static void main(String[] args) {
		//Frame ����򣬴����ڿ� 
		JFrame frame = new JFrame();
		//panel �������
		Tetris panel = new Tetris();
		//Background ����
		panel.setBackground(Color.YELLOW);
		//������������
		frame.add(panel);
		frame.setSize(535, 580);
		//����
		frame.setLocationRelativeTo(null);
		//���Xʱ��ͬʱ�رճ���
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		//��ʾ���ڿ�
		frame.setVisible(true);
		//����ĵ��� paint()����������ʾ����
		//��ʾ�����Ժ�ִ�� ��������action
		panel.action();
	}
}




