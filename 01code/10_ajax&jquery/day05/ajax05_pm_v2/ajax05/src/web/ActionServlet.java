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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		if(action.equals("/getPrice")){
			String flight = 
				request.getParameter("flight");
			if("CA1234".equals(flight)){
				out.println("ͷ�Ȳ�:��2400<br/>�����:��2200");
			}else{
				out.println("ͷ�Ȳ�:��2000<br/>�����:��1800");
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
		}else if(action.equals("/getItems")){
			if(1==2){
				throw new ServletException("ϵͳ�쳣");
			}
			String keyword = 
				request.getParameter("keyword");
			if("С".equals(keyword)){
				out.println("С��,С˵,Сѧ������,Сѧ������");
			}else if("Сѧ".equals(keyword)){
				out.println("Сѧ������,Сѧ������");
			}else if("��".equals(keyword)){
				out.println("����,������,���¸�");
			}
		}
		out.close();
	}

}
