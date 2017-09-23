package com.tarena.tetris;
 

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * ����˹����
 * 
 * ����˹���� ��չ��(�̳���) �հ����
 * ������� ��չ�� wall �� ��������ķ���tetromino
 */
public class Tetris extends JPanel{
	private int score;
	private int lines;
	public static final int ROWS = 20;
	public static final int COLS = 10;
	/** ����ǽ */
	private Cell[][] wall = new Cell[ROWS][COLS];
	/** �������䷽�� */
	private Tetromino tetromino;
	/** ��һ�������ķ��� */
	private Tetromino nextOne;
	/** ����ͼƬ */
	private static BufferedImage background;
	public static BufferedImage T;
	public static BufferedImage S;
	public static BufferedImage Z;
	public static BufferedImage J;
	public static BufferedImage L;
	public static BufferedImage I;
	public static BufferedImage O;
	public static BufferedImage gameOverImage;
	
	private Timer timer;
	private long index=0;//���������
	private int interval = 50;//����ʱ����
	private long intervalTime = 1000/100;//����ʱ���
	private boolean pause = false;
	
	/** ��̬����� ���ڵ���API��ȡͼƬ�ļ����ڴ���� */
	static{
		try{
			//Tetris.class.getResource("tetris.png")
			//�Ǵ�Tetris.class��İ��л�ȡ�ļ�tetris.png
			//ע��: Tetris.class ������tetris.png��ͬһ������!
			background=ImageIO.read(
					Tetris.class.getResource("tetris.png"));
			T=ImageIO.read(Tetris.class.getResource("T.png"));
			S=ImageIO.read(Tetris.class.getResource("S.png"));
			J=ImageIO.read(Tetris.class.getResource("J.png"));
			L=ImageIO.read(Tetris.class.getResource("L.png"));
			Z=ImageIO.read(Tetris.class.getResource("Z.png"));
			O=ImageIO.read(Tetris.class.getResource("O.png"));
			I=ImageIO.read(Tetris.class.getResource("I.png"));
			gameOverImage=ImageIO.read(
					Tetris.class.getResource("game-over.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/** Tetris ���� ��д(�޸�)һ������ paint()
	 * paint "Ϳ"��   draw"��"�� 
	 * JPanel ���paint�����ǻ������ķ��� */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//����ͼƬ
		//g.setColor(Color.blue);
		//g.drawString("Hello good", 50, 50);
		//����ǽ
		g.translate(15, 15);//ƽ������ϵ
		paintWall(g);
		//������������ķ���
		paintTetromino(g);
		paintNextOne(g);
		paintScore(g);
		//������Ϸ�� ��ͣ ����״̬
		g.translate(-15, -15);
		paintState(g);
	}
	/** ������Ϸ�� ��ͣ ����״̬ */
	private void paintState(Graphics g) {
		if(gameOver){
			g.drawImage(gameOverImage, 0, 0, null);
		}
		int x = 290+15;
		int y = 160+56+56+15;
		if(pause){
			g.drawString("[C]Continue", x, y);
		}else{
			g.drawString("[P]Pause", x, y);
		}
	}

	private void paintScore(Graphics g) {
		int x = 290;
		int y = 160;
		g.setColor(new Color(0x667799));
		Font font = g.getFont();
		Font f = new Font(
				font.getName(), font.getStyle(),30);
		g.setFont(f);
		String str = "SCORE:"+score;
		g.drawString(str, x, y);
		y+=56;
		str = "LINES:"+lines;
		g.drawString(str, x, y);
	}

	private void paintNextOne(Graphics g) {
		if (nextOne == null) {
			return;
		}
		Cell[] cells = nextOne.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow()+1;
			int col = cell.getCol()+10;
			int x = col * CELL_SIZE;
			int y = row * CELL_SIZE;
			g.drawImage(cell.getImage(), x, y, null);
		}
	}
	/** ������������ķ��� */
	private void paintTetromino(Graphics g) {
		// ���û����������ķ���,��ֱ�ӷ���,��������
		if (tetromino == null) {
			return;
		}
		// ��ȡ�������䷽���4������
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			// cell ����ÿ������
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			int x = col * CELL_SIZE;
			int y = row * CELL_SIZE;
			g.drawImage(cell.getImage(), x, y, null);
		}
	}

	public static final int CELL_SIZE = 26;
	/** ����ǽ */
	private void paintWall(Graphics g){
		for(int row=0; row<wall.length; row++){
			Cell[] line = wall[row];
			for(int col=0; col<line.length; col++){
				Cell cell = line[col];
				int x = col * CELL_SIZE;
				int y = row * CELL_SIZE;
				//g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
				//�������ש��, �Ͱ�ש���ͼƬ���Ƴ���
				if(cell != null){
					g.drawImage(cell.getImage(), x, y, null);
				}
			}
		}
	}
	/** Tetris �� ��� 4�񷽿����ƶ���������(���߽���)
	 * �㷨���̣��ȳ��Խ� 4�񷽿������ƶ�������ƶ��Ժ�
	 *   ���磬 ���ٽ�4�񷽿����ƶ���
	 * */
	public void moveRightAction(){
		tetromino.moveRight();
		if(outOfBounds() || coincide()){//coincide�غ�
			tetromino.moveLeft();
		}
	}
	/** ? �����㷨 */
	public void moveLeftAction(){
		tetromino.moveLeft();
		if(outOfBounds() || coincide()){
			tetromino.moveRight();
		}
	}
	/** ��⵱ǰ4�񷽿��Ƿ���ǽ�ϵķ����غ� */
	private boolean coincide() {
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row=cell.getRow(); 
			int col=cell.getCol();
			if(wall[row][col]!=null){
				return true; //�����غϵ�ǽש!
			}
		}
		return false;
	}

	/** ��⵱ǰ�����4�񷽿��Ƿ����,����true ��ʾ�����ˣ� */
	private boolean outOfBounds(){
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row=cell.getRow(); int col=cell.getCol();
			if(row<0 || row>=ROWS || col<0 || col>=COLS){
				return true;
			}
		}
		return false;
	}
	private boolean gameOver = false;
	/** ��Tetris ������ӣ��������̿��Ʒ���  */
	public void softDropAction(){
		if(canDrop()){
			tetromino.softDrop();
		}else{
			landIntoWall();//4�񷽿���½��ǽ����
			destoryLines();
			gameOver = checkGameOver();
			if(! gameOver){
				tetromino = nextOne;
				nextOne = Tetromino.randomOne();
			}
		}
	}
	/** �����Ϸ�Ƿ���� */
	private boolean checkGameOver() {
		Cell[] cells = nextOne.cells;
		for(Cell cell : cells){
			int row = cell.getRow();
			int col = cell.getCol();
			if(wall[row][col]!=null){
				return true;//��Ϸ�ý�����
			}
		}
		return false;
	}
	private int[] scoreTable = {0,10,30,50,100};
	//                          0  1  2  3   4
	/** ������, ��0~19���ÿ����, ���һ�ж��Ǹ���(��)
	 * �ͽ��������� */
	private void destoryLines() {
		int lines = 0;// 0 1 2 3 4
		for(int row=0; row<ROWS; row++){
			if(fullCells(row)){//���һ��row�������Ǹ���
				deleteLine(row);
				lines++;
			}
		}
		this.lines += lines;
		this.score += scoreTable[lines];
	}
	
	private boolean fullCells(int row) {
		Cell[] line = wall[row];
		for(Cell cell:line){
			if(cell==null){
				return false;
			}
		}
		return true;
	}

	/** ����ǽ�е���,row�Ǳ����ٵ��к� */
	private void deleteLine(int row){
		//row = 19
		for(int i=row; i>=1; i--){
			System.arraycopy(wall[i-1],0,wall[i],0,COLS);
		}
		Arrays.fill(wall[0], null);
	}
	
	/** ��½��ǽ���� */
	private void landIntoWall() {
		Cell[] cells = tetromino.cells;
		for(Cell cell:cells){
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col] = cell;
		}
		tetromino = null;//����������ķ���˵�ټ�!
	}
	/** ���4�񷽿��Ƿ������� */
	private boolean canDrop() {
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell=cells[i];
			int row = cell.getRow();
			if(row>=ROWS-1){
				return false;//����, ����������
			}
		}
		for(Cell cell:cells){//cell����cells��ÿ������
			int row = cell.getRow();int col = cell.getCol();
			if(wall[row+1][col]!=null){
				return false;//�·���ש, ��������
			}
		}
		return true;
	}

	public void hardDropAction(){
		while(canDrop()){//�� �������� ʱ�� ������һ��
			tetromino.softDrop();
		}
		landIntoWall();
		destoryLines();
		gameOver = checkGameOver();
		if(!gameOver){
			tetromino=nextOne;
			nextOne = Tetromino.randomOne();
		}
	}
	
	/** ��Tetris �������ת���̿��Ʒ��� */
	public void rotateRightAction(){
		//System.out.println("t1:"+tetromino);
		tetromino.rotateRight();
		if(outOfBounds() || coincide()){
			tetromino.rotateLeft();
		}
		//System.out.println("t2:"+tetromino);
	}
	public void rotateLeftAction(){
		tetromino.rotateLeft();
		if(outOfBounds() || coincide()){
			tetromino.rotateRight();
		}
	}
	
	private void clearAll(){
		score = 0;
		lines = 0;
		index = 0;
		interval = 50;
		gameOver = false;
		pause = false;
		this.tetromino = Tetromino.randomOne();
		this.nextOne = Tetromino.randomOne();
		for(Cell[] line: wall){
			Arrays.fill(line, null);
		}
	}
	/** ��Tetris ������ӷ���, action��ʼ  */
	public void action(){
		clearAll();

		KeyListener l = new KeyAdapter(){
			/** �ڰ�������(�κ�)ʱ��ִ�� */
			//KeyEvent e ��һ���¼�����, ��������з�װ��
			//�����¼�ʱ��� ʱ��,�ص�(�Ǹ��ؼ�),����(�Ǹ�����) ��
			//long when = e.getWhen();
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();//��ȡ���µİ�������
				if(key==KeyEvent.VK_Q){//QUIT
					System.exit(0);//������Java����
				}
				if(gameOver){
					if(key==KeyEvent.VK_S){
						clearAll();//����ǽ ���� ��
						gameOver = false;
					}
					return;
				}
				if(pause){
					if(key==KeyEvent.VK_C){
						pause = false;index = 0;
					}
					return;
				}
				switch (key) {
				case KeyEvent.VK_DOWN:softDropAction();	break;
				case KeyEvent.VK_RIGHT:moveRightAction();break;
				case KeyEvent.VK_LEFT:moveLeftAction();break;
				case KeyEvent.VK_SPACE:hardDropAction();break;
				case KeyEvent.VK_UP:rotateRightAction();break;
				case KeyEvent.VK_P:	pause = true;	break;
				}
				repaint();//�ᾡ��ĵ��� paint()
			}
		};
		this.addKeyListener(l);//��l�뵱ǰ����
		this.requestFocus();//Ϊ��ǰ�����������
		
		//��action() ��������Ӷ�ʱ�������
		//interval ��ֵԽС������Խ��
		timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				index++;
				if(index % interval == 0){
					//System.out.println("pause:"+pause);
					//System.out.println("gameOver:"+gameOver);
					//System.out.println("!gameOver || ! pause:"+
					//		(!gameOver || ! pause));
					if(!gameOver && ! pause ){
						softDropAction();
					}
				}
				repaint();
			}
		}, 0, intervalTime);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();//���ڿ�(Frame)
		Tetris panel = new Tetris();//�հ����
		frame.add(panel);//������������
		//panel.setBackground(Color.blue);//������屳��ɫ
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		frame.setSize(525, 550);
		frame.setLocationRelativeTo(null);//������
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);//��ʾ���ڿ�
		//��ʾ���� ʱ�� �ᾡ��ĵ��� ��� paint()����
		panel.action();//����
	}
}



