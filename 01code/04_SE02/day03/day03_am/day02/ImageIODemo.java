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
 * ��дͼƬ��ʵ�� ˮӡǩ�� 
 */
public class ImageIODemo {
	public static void main(String[] args) 
		throws IOException {
		//ԭ�ļ�
		String src = "img.png";
		//Ŀ���ļ�
		String dest = "demo.png";
		//1 ��ȡԭ�ļ��� Image����
		//2 ��Image����ǩ��
		//3 д��Image���� �� demo.png
		//���ļ�
		InputStream in = 
			new BufferedInputStream(
			new FileInputStream(src));
		//��in��byte ��ȡ������Ϊ ͼƬ����
		BufferedImage img=
			ImageIO.read(in);
		in.close();
		//�õ�ͼƬ�����ϰ󶨵Ļ���
		Graphics g = img.getGraphics();
		//Ϊ�������ð�͸����ɫ
		g.setColor(
		  new Color(0x55ffffff, true));
		//����ǩ��
		g.drawString("������", 30, 30);
		//������ļ�
		OutputStream out = 
			new BufferedOutputStream(
			new FileOutputStream(dest));
		//��ͼƬд�����ļ�
		ImageIO.write(img, "png", out);
		out.close();
	}
}









