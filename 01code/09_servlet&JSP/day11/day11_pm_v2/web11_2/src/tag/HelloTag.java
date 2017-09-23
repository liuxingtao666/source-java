package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ��ǩ��Ҫ�������¹���������
 * 	1.�̳�SimpleTagSupport��
 *  2.override SimpleTagSupport���
 *  doTag������
 *  3.��ǩ���������ǩ�������Ҫһ��(
 *  ������һ��������Ҫƥ��)�����ң�Ҫ�ṩ
 *  ��Ӧ��set������
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
		//ͨ��SimpleTagSupport�ṩ�ķ���
		//�����PageContext
		PageContext ctx = 
			(PageContext)getJspContext();
		//ͨ��PageContext�����ҵ��������е�
		//��������
		JspWriter out = ctx.getOut();
		for(int i=0;i<qty;i++){
			out.println(info + "<br/>");
		}
	}
	
}
