package com.tarena.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

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
					tetromino.softDrop();
					break;
				}
				repaint();
			}
		};
		//添加监听器到当前面板（挂载）
		this.addKeyListener(l);
		//为当前面板申请输入焦点
		//有焦点才能接收键盘事件
		this.requestFocus();
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
		//显示窗口以后，执行 启动方法action
		panel.action();
	}
}




