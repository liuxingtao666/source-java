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
 * 俄罗斯方块
 * 
 * 俄罗斯方块 扩展了(继承于) 空白面板
 * 在面板上 扩展出 wall 和 正在下落的方块tetromino
 */
public class Tetris extends JPanel{
	private int score;
	private int lines;
	public static final int ROWS = 20;
	public static final int COLS = 10;
	/** 方块墙 */
	private Cell[][] wall = new Cell[ROWS][COLS];
	/** 正在下落方块 */
	private Tetromino tetromino;
	/** 下一个出场的方块 */
	private Tetromino nextOne;
	/** 背景图片 */
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
	private long index=0;//间隔计数器
	private int interval = 50;//下落时间间隔
	private long intervalTime = 1000/100;//主定时间隔
	private boolean pause = false;
	
	/** 静态代码块 用于调用API读取图片文件到内存对象 */
	static{
		try{
			//Tetris.class.getResource("tetris.png")
			//是从Tetris.class类的包中获取文件tetris.png
			//注意: Tetris.class 必须与tetris.png在同一个包中!
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

	/** Tetris 类中 重写(修改)一个方法 paint()
	 * paint "涂"画   draw"绘"画 
	 * JPanel 类的paint方法是绘制面板的方法 */
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, null);//绘制图片
		//g.setColor(Color.blue);
		//g.drawString("Hello good", 50, 50);
		//绘制墙
		g.translate(15, 15);//平移坐标系
		paintWall(g);
		//绘制正在下落的方块
		paintTetromino(g);
		paintNextOne(g);
		paintScore(g);
		//绘制游戏的 暂停 结束状态
		g.translate(-15, -15);
		paintState(g);
	}
	/** 绘制游戏的 暂停 结束状态 */
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
	/** 绘制正在下落的方块 */
	private void paintTetromino(Graphics g) {
		// 如何没有正在下落的方块,就直接返回,不绘制了
		if (tetromino == null) {
			return;
		}
		// 获取正在下落方块的4个格子
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			// cell 代表每个格子
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			int x = col * CELL_SIZE;
			int y = row * CELL_SIZE;
			g.drawImage(cell.getImage(), x, y, null);
		}
	}

	public static final int CELL_SIZE = 26;
	/** 绘制墙 */
	private void paintWall(Graphics g){
		for(int row=0; row<wall.length; row++){
			Cell[] line = wall[row];
			for(int col=0; col<line.length; col++){
				Cell cell = line[col];
				int x = col * CELL_SIZE;
				int y = row * CELL_SIZE;
				//g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
				//如果发现砖块, 就把砖块的图片绘制出来
				if(cell != null){
					g.drawImage(cell.getImage(), x, y, null);
				}
			}
		}
	}
	/** Tetris 类 添加 4格方块右移动控制流程(含边界检测)
	 * 算法流程：先尝试将 4格方块先右移动，如果移动以后
	 *   出界， 则再将4格方块左移动。
	 * */
	public void moveRightAction(){
		tetromino.moveRight();
		if(outOfBounds() || coincide()){//coincide重合
			tetromino.moveLeft();
		}
	}
	/** ? 描述算法 */
	public void moveLeftAction(){
		tetromino.moveLeft();
		if(outOfBounds() || coincide()){
			tetromino.moveRight();
		}
	}
	/** 检测当前4格方块是否与墙上的方块重合 */
	private boolean coincide() {
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row=cell.getRow(); 
			int col=cell.getCol();
			if(wall[row][col]!=null){
				return true; //发现重合的墙砖!
			}
		}
		return false;
	}

	/** 检测当前下落的4格方块是否出界,返回true 表示出界了！ */
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
	/** 在Tetris 类中添加，下落流程控制方法  */
	public void softDropAction(){
		if(canDrop()){
			tetromino.softDrop();
		}else{
			landIntoWall();//4格方块着陆到墙里面
			destoryLines();
			gameOver = checkGameOver();
			if(! gameOver){
				tetromino = nextOne;
				nextOne = Tetromino.randomOne();
			}
		}
	}
	/** 检测游戏是否结束 */
	private boolean checkGameOver() {
		Cell[] cells = nextOne.cells;
		for(Cell cell : cells){
			int row = cell.getRow();
			int col = cell.getCol();
			if(wall[row][col]!=null){
				return true;//游戏该结束了
			}
		}
		return false;
	}
	private int[] scoreTable = {0,10,30,50,100};
	//                          0  1  2  3   4
	/** 销毁行, 从0~19检查每个行, 如果一行都是格子(满)
	 * 就将这行销毁 */
	private void destoryLines() {
		int lines = 0;// 0 1 2 3 4
		for(int row=0; row<ROWS; row++){
			if(fullCells(row)){//如果一行row满满都是格子
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

	/** 销毁墙中的行,row是被销毁的行号 */
	private void deleteLine(int row){
		//row = 19
		for(int i=row; i>=1; i--){
			System.arraycopy(wall[i-1],0,wall[i],0,COLS);
		}
		Arrays.fill(wall[0], null);
	}
	
	/** 着陆到墙里面 */
	private void landIntoWall() {
		Cell[] cells = tetromino.cells;
		for(Cell cell:cells){
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col] = cell;
		}
		tetromino = null;//和正在下落的方块说再见!
	}
	/** 检查4格方块是否能下落 */
	private boolean canDrop() {
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell=cells[i];
			int row = cell.getRow();
			if(row>=ROWS-1){
				return false;//到底, 不能下落了
			}
		}
		for(Cell cell:cells){//cell代表cells中每个格子
			int row = cell.getRow();int col = cell.getCol();
			if(wall[row+1][col]!=null){
				return false;//下方有砖, 不能下落
			}
		}
		return true;
	}

	public void hardDropAction(){
		while(canDrop()){//当 可以下落 时候 就下落一次
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
	
	/** 在Tetris 类添加旋转流程控制方法 */
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
	/** 在Tetris 类中添加方法, action开始  */
	public void action(){
		clearAll();

		KeyListener l = new KeyAdapter(){
			/** 在按键按下(任何)时候执行 */
			//KeyEvent e 是一个事件对象, 这个对象中封装了
			//发生事件时候的 时间,地点(那个控件),人物(那个按键) 等
			//long when = e.getWhen();
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();//获取按下的按键数字
				if(key==KeyEvent.VK_Q){//QUIT
					System.exit(0);//将结束Java进程
				}
				if(gameOver){
					if(key==KeyEvent.VK_S){
						clearAll();//清理墙 分数 等
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
				repaint();//会尽快的调用 paint()
			}
		};
		this.addKeyListener(l);//将l与当前面板绑定
		this.requestFocus();//为当前面板请求输入
		
		//在action() 方法中添加定时处理代码
		//interval 数值越小，下落越快
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
		JFrame frame = new JFrame();//窗口框(Frame)
		Tetris panel = new Tetris();//空白面板
		frame.add(panel);//画框中添加面板
		//panel.setBackground(Color.blue);//设置面板背景色
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		frame.setSize(525, 550);
		frame.setLocationRelativeTo(null);//居中了
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);//显示窗口框
		//显示窗口 时候 会尽快的调用 面板 paint()方法
		panel.action();//启动
	}
}



