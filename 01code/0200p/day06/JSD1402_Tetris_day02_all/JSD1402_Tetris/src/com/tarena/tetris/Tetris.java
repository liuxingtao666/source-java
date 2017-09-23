package com.tarena.tetris;

import java.awt.Color;
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
 * 俄罗斯方块
 *
 */
public class Tetris extends JPanel {
	/** 分数 */
	private int score;
	/** 行数， 销毁的总行数 */
	private int lines;
	public static final int ROWS = 20;
	public static final int COLS = 10;
	/** 方块墙 */
	private Cell[][] wall=new Cell[ROWS][COLS];
	/** 正在下落的方块 */
	private Tetromino tetromino;
	/** 下一个方块 */
	private Tetromino nextOne;
	
	/** 在Tetris 中添加背景图属性 */
	private static BufferedImage background;
	public static BufferedImage gameOverImage;
	public static BufferedImage T;
	public static BufferedImage S;
	public static BufferedImage Z;
	public static BufferedImage J;
	public static BufferedImage L;
	public static BufferedImage I;
	public static BufferedImage O;
	
	/** 读取图片文件到内存对象 */
	//将图片复制到 com.tarena.tetris包中
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
	/** 利用重写方法修改父类JPanel */
	//paint:涂绘， Graphics：图，画笔
	public void paint(Graphics g){
		//draw: 绘
		g.drawImage(background, 0, 0, null);
		g.drawString("Hello", 50, 50);
		g.translate(15, 15);
		paintWall(g);
		paintTetromino(g);
		paintNextOne(g);
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
	/** 在Tetris类中填方法,绘制正在下落的方块 */
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
	/** 在Tetris 添加画墙的方法 */
	private void paintWall(Graphics g){
		for(int row=0; row<ROWS; row++){
			for(int col=0; col<COLS; col++){
				Cell cell = wall[row][col];
				int x=CELL_SIZE * col;
				int y=CELL_SIZE * row;
				if(cell==null){
					g.drawRect(x, y, 
						CELL_SIZE, CELL_SIZE);
				}else{
					g.drawImage(cell.getImage(),
							x,y,null);
				}
			}
		}
	}
	
	/** 在Tetris 类中添加方法 */
	public void action(){
		wall[19][2]=new Cell(19,2,T);
		//尽快的调用paint()重新绘制面板
		tetromino = Tetromino.randomOne();
		nextOne = Tetromino.randomOne();
		repaint();
		//创建键盘事件监听器对象
		KeyListener l=new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				switch(key){
				case KeyEvent.VK_DOWN:
					softDropAction();
					break;
				case KeyEvent.VK_RIGHT:
					moveRightAction();
					break;
				case KeyEvent.VK_LEFT:
					moveLeftAction();
					break;
				case KeyEvent.VK_UP:
					rotateRightAction();
					break;
				}
				repaint();
			}
		};
		//添加监听器到当前面板（挂载）
		this.addKeyListener(l);
		//为当前面板申请输入焦点，有焦点才能接收键盘事件
		this.requestFocus();
	}
	/** 在Tetris 类中填写方法 softDropAction */
	private void softDropAction(){
		boolean drop = canDrop();
		//System.out.println("t:"+tetromino); 
		//System.out.println("canDrop:"+drop); 
		if(drop){
			tetromino.softDrop();
		}else{
			// 入墙,land着陆 into进去 Wall 墙
			landIntoWall();//封装 方块入墙 的算法
			// 销毁行 destroyLines，计分
			destroyLines();//封装销毁行的算法
			// 检查是否结束
			// 如果游戏没有结束，产生下一个方块
			if(!isGameOver()){
				tetromino=nextOne;
				nextOne=Tetromino.randomOne();
			}
		}
		System.out.println(tetromino); 
	}
	/** 检查游戏是否结束
	 * 如果下一个将要出场的方块的墙上位置被占用
	 * 了就结束了！
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
	/** 销毁墙上已经满的行 */
	private void destroyLines() {
		for(int row=0; row<ROWS; row++){
			if(fullCells(row)){
				deleteRow(row);
			}
		}
	}
	/** 检查墙上row行是否是"满格子"，true：满了 */
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
	/** 删除墙上 row对应的行 */
	private void deleteRow(int row) {
		for(int i=row; i>=1; i--){
			System.arraycopy(wall[i-1], 0, 
					wall[i], 0, COLS);
		}
		Arrays.fill(wall[0], null);
	}
	/** 将方块着陆到墙上 */
	private void landIntoWall() {
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col]=cell;
		}
	}
	/** 在Tetris类中添加方法 canDrop() */
	private boolean canDrop(){
		//输入是 wall tetromino 
		//先检查tetromino是否到达底部
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			//i = 0 1 2 3 
			//cell“引用”了4格方块的每个格式
			Cell cell = cells[i];
			//如果某个格子的行是19，就不能下落了
			if(cell.getRow() == ROWS-1){
				//System.out.println("到达底部");
				return false;
			}
		}
		
		//检查tetromino的下方墙上是否有方块
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if(wall[row+1][col]!=null){
				//System.out.println(cell+"的下方有方块");
				return false;
			}
		}
		return true;
	}
	
	/** Tetris 类中添加向右移动流程控制方法 */
	private void moveRightAction(){
		tetromino.moveRight();
		//outOfBounds出界 concide：重合
		if(outOfBounds() || concide()){
			tetromino.moveLeft();
		}
	}
	private void moveLeftAction(){
		tetromino.moveLeft();
		//outOfBounds出界 concide：重合
		if(outOfBounds() || concide()){
			tetromino.moveRight();
		}
	}
	//检查当前下落的方块，是否出界，true：出界了
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
	//检查当前下落的方块，是否与墙砖重合，true重合
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
	/** 在tetris 类中增加旋转流程控制方法 */
	public void rotateRightAction(){
		//rotate:原地转
		tetromino.rotateRight();
		if(outOfBounds() || concide()){
			tetromino.rotateLeft();
		}
	}
	
	public static void main(String[] args) {
		//Frame 框，相框，代表窗口框 
		JFrame frame = new JFrame();
		//panel 代表面板
		Tetris panel = new Tetris();
		//Background 背景
		panel.setBackground(Color.YELLOW);
		//窗口中添加面板
		frame.add(panel);
		frame.setSize(535, 580);
		//居中
		frame.setLocationRelativeTo(null);
		//点击X时候同时关闭程序
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		//显示窗口框
		frame.setVisible(true);
		//尽快的调用 paint()方法绘制显示界面
		//显示窗口以后，执行 启动方法action
		panel.action();
	}
}




