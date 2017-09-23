package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 标签类要按照如下规则来开发
 * 	1.继承SimpleTagSupport类
 *  2.override SimpleTagSupport类的
 *  doTag方法。
 *  3.标签的属性与标签类的属性要一致(
 *  属性名一样，类型要匹配)，并且，要提供
 *  对应的set方法。
 *
 * @author Administrator
 *
 */
public class HelloTag extends SimpleTagSupport{
	private String info;
	private int qty;
	public HelloTag(){
		System.out.println("HelloTag's constructor...");
	}
	public void setInfo(String info) {
		System.out.println("setInfo..." + info);
		this.info = info;
	}

	public void setQty(int qty) {
		System.out.println("setQty...");
		this.qty = qty;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag...");
		//通过SimpleTagSupport提供的方法
		//来获得PageContext
		PageContext ctx = 
			(PageContext)getJspContext();
		//通过PageContext可以找到其它所有的
		//隐含对象
		JspWriter out = ctx.getOut();
		for(int i=0;i<qty;i++){
			out.println(info + "<br/>");
		}
	}
	
}
