package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SecondInterceptor 
	implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(
			ActionInvocation ai) 
		throws Exception {
		System.out.println("SecondInterceptor拦截前...");
		//调用Action
		ai.invoke();
		System.out.println("SecondInterceptor拦截后...");
		return null;
	}

}
