package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckcodeServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CheckcodeServlet's service");
		/*
		 * һ����ͼ
		 */
		/*
		 * step1,����һ���ڴ�ӳ�����(����)
		 * BufferedImage(���,�߶�,����)
		 */
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		/*
		 * step2,���һ������
		 */
		Graphics g = image.getGraphics();
		/*
		 * step3,����������ɫ
		 */
		Random r = new Random();
		g.setColor(new Color(255,255,255));
		/*
		 * step4,���������ñ�����ɫ
		 * fillRect(x,y,width,height)
		 */
		g.fillRect(0, 0, 80, 30);
		/*
		 * step5,��ͼ
		 */
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//Font(����,���,��С)
		g.setFont(new Font(null,Font.ITALIC,22));
		String number = getNumber(5);
		//��number�󶩵�session������
		HttpSession session = 
			request.getSession();
		session.setAttribute("number", number);
		//drawString(String,x,y) x,y�����½ǵ�����
		g.drawString(number, 2, 23);
		//step6,��һЩ������
		for(int i=0;i<6;i++){
			g.drawLine(r.nextInt(80), 
					r.nextInt(30), 
					r.nextInt(80), r.nextInt(30));
		}
		
		/*
		 * ������ͼƬѹ�������͸������
		 */
		//����content-type��Ϣͷ������
		//��������ص���ͼƬ
		response.setContentType("image/jpeg");
		//һ��Ҫ����ֽ������
		OutputStream ops = 
			response.getOutputStream();
		//write�������ԭʼͼƬ(image)����
		//ָ����ѹ���㷨(jpeg)����ѹ��������
		//��ѹ��֮������������ָ������(ops)��
		javax.imageio.ImageIO
		.write(image, "jpeg", ops);
		ops.close();
	}
	
	/*
	 * ����һ����֤�룬����֤����"A~Z","0~9"��
	���ѡȡ5���ַ����
	 */
	private String getNumber(int size) {
		String rs = "";
		String strs = "ABCDEFGHIJKLMNOPQ" +
				"RSTUVWXYZ0123456789";
		Random r = new Random();
		for(int i=0;i<size;i++){
			rs += strs.charAt(r.nextInt(strs.length()));
		}
		return rs;
	}

}
