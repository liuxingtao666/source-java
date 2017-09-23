package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountLimitException;
import service.AccountNotExsitException;
import service.AccountService;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String action = 
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		/*
		 * 依据请求，调用相应的模型来处理
		 */
		if(action.equals("/to_apply")){
			request.getRequestDispatcher("/WEB-INF/jsp/apply_form.jsp")
			.forward(request, response);
		}else if(action.equals("/apply")){
			String accountNo = 
				request.getParameter("accountNo");
			String amount = 
				request.getParameter("amount");
			AccountService service =
				new AccountService();
			try {
				String number = 
					service.apply(accountNo, 
							Double.parseDouble(amount));
				/*
				 * 依据模型返回的结果，选择合适的
				 * 视图来展现
				 */
				request.setAttribute("number", number);
				request.getRequestDispatcher("/WEB-INF/jsp/view2.jsp")
				.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				if(e instanceof AccountLimitException){
					request.setAttribute("limit_error", 
							"余额不足");
					request.getRequestDispatcher("/WEB-INF/jsp/apply_form.jsp")
					.forward(request, response);
				}else if(e instanceof AccountNotExsitException){
					request.setAttribute("exist_error", 
					"帐号不存在");
			request.getRequestDispatcher("/WEB-INF/jsp/apply_form.jsp")
			.forward(request, response);
				}else{
					request.getRequestDispatcher("/WEB-INF/jsp/error.jsp")
					.forward(request, response);
				}
			}
			
		}
	}

}
