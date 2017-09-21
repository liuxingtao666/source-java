package day02;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/**
 * 读写图片，实现 水印签名 
 */
public class ImageIODemo {
	public static void main(String[] args) 
		throws IOException {
		//原文件
		String src = "img.png";
		//目标文件
		String dest = "demo.png";
		//1 读取原文件到 Image对象
		//2 在Image绘制签名
		//3 写出Image对象 到 demo.png
		//打开文件
		InputStream in = 
			new BufferedInputStream(
			new FileInputStream(src));
		//把in中byte 读取并解析为 图片对象
		BufferedImage img=
			ImageIO.read(in);
		in.close();
		//拿到图片对象上绑定的画笔
		Graphics g = img.getGraphics();
		//为画笔设置半透明颜色
		g.setColor(
		  new Color(0x55ffffff, true));
		//绘制签名
		g.drawString("刘苍松", 30, 30);
		//打开输出文件
		OutputStream out = 
			new BufferedOutputStream(
			new FileOutputStream(dest));
		//将图片写出到文件
		ImageIO.write(img, "png", out);
		out.close();
	}
}









