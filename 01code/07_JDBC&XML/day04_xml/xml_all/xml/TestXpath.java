package xml;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXpath {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//根据test02.xml创建文档树对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read(
			new File("src/xml/test02.xml"));
		//利用xpath快速定位name=天龙八部的book元素
		Element book = (Element)
			doc.selectSingleNode(
			"//book[name='天龙八部']");
		//获取book的price子元素值
		String price = 
			book.element("price").getText();
		System.out.println(price);
	}

}
