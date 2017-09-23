package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import bean.Stock;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = 
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		if(action.equals("/check_username")){
			//ģ����������бȽϺ�ʱ�Ĳ���
//			try {
//				Thread.sleep(6000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			//ģ��һ��ϵͳ�쳣
//			if(1==1){
//				throw new ServletException(
//						"ģ��ϵͳ�쳣");
//			}
			String username =
				 request.getParameter("username");
			System.out.println(username);
			if("���".equals(username)){
				out.println("�û�����ռ��");
			}else{
				out.println("����ʹ��");
			}
		}else if(action.equals("/quoto")){
			/*
			 * ģ�����ɼ�֧��Ʊ����Ϣ
			 */
			List<Stock> stocks = 
				new ArrayList<Stock>();
			Random r = new Random();
			for(int i=0;i<8;i++){
				Stock s = new Stock();
				s.setCode("60001" + r.nextInt(10));
				s.setName("ɽ������"+ r.nextInt(10));
				double price = r.nextDouble() * 100;
				DecimalFormat df = 
					new DecimalFormat("#.##");
				s.setPrice(df.format(price));
				stocks.add(s);
			}
			JSONArray obj = 
				JSONArray.fromObject(stocks);
			String str = obj.toString();
			System.out.println(str);
			out.println(str);
		}
		out.close();
	}

}
