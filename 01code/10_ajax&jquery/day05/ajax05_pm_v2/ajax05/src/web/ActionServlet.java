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
				out.println("头等舱:￥2400<br/>商务舱:￥2200");
			}else{
				out.println("头等舱:￥2000<br/>商务舱:￥1800");
			}
		}else if(action.equals("/quoto")){
			/*
			 * 模拟生成几支股票的信息
			 */
			List<Stock> stocks = 
				new ArrayList<Stock>();
			Random r = new Random();
			for(int i=0;i<8;i++){
				Stock s = new Stock();
				s.setCode("60001" + r.nextInt(10));
				s.setName("山东高速"+ r.nextInt(10));
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
				throw new ServletException("系统异常");
			}
			String keyword = 
				request.getParameter("keyword");
			if("小".equals(keyword)){
				out.println("小米,小说,小学生作文,小学生早恋");
			}else if("小学".equals(keyword)){
				out.println("小学生作文,小学生早恋");
			}else if("郭".equals(keyword)){
				out.println("郭靖,郭美美,郭德刚");
			}
		}
		out.close();
	}

}
