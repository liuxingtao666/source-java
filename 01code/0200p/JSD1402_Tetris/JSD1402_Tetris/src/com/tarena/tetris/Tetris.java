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
 * ����˹����
 *
 */
public class Tetris extends JPanel {
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
					g.drawRect(x, y, 
						CELL_SIZE, CELL_SIZE);
				}else{
					g.drawImage(cell.getImage(),
							x,y,null);
				}
			}
		}
	}
	
	/** ��Tetris ������ӷ��� */
	public void action(){
		wall[19][2]=new Cell(19,2,T);
		//����ĵ���paint()���»������
		tetromino = Tetromino.randomOne();
		nextOne = Tetromino.randomOne();
		repaint();
		//���������¼�����������
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
		//��Ӽ���������ǰ��壨���أ�
		this.addKeyListener(l);
		//Ϊ��ǰ����������뽹��
		//�н�����ܽ��ռ����¼�
		this.requestFocus();
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
		//��ʾ�����Ժ�ִ�� ��������action
		panel.action();
	}
}




