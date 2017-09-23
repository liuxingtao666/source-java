package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *	第一个拦截器组件
 */
public class FirstInterceptor 
	implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	/* 
	 * 拦截器的拦截方法，可以拦截到Action的
	 * 请求，并在拦截前和拦截后都能对Action
	 * 进行扩展。
	 * 特殊情况下，也可以拒绝用户访问Action。
	 */
	public String intercept(
			ActionInvocation ai) 
		throws Exception {
		//模拟拦截前的扩展业务
		System.out.println("FirstInterceptor拦截前...");
		/*
		 * ai.invoke()是拦截器主动调用Action
		 * 的方法，如果拦截器中没有调用该方法，
		 * 那么引用这个拦截器的Action将不会
		 * 被调用。
		 * */
		ai.invoke();
		//模拟调用Action后的扩展业务
		System.out.println("FirstInterceptor拦截后...");
		/*
		 * 拦截器的返回值也是用于匹配result的，
		 * 但仅仅是拦截方法中没有调用ai.invoke
		 * 时，该返回值生效。如果调用了Action，
		 * 则一定按照Action的返回值匹配result，
		 * 即这种情况下该返回值失效。
		 * */
		return "error";
	}

}
