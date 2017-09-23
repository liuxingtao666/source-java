package xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestParseXml {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		testParse();
	}
	
	public static void testParse() throws Exception{
		//创建解析器对象
		SAXReader reader = new SAXReader();
		//读取src/xml/test02.xml,构建doc文档树对象
		Document doc = reader.read(
			new File("src/xml/test02.xml"));
		//获取doc树的根元素
		Element root = 
			doc.getRootElement();
		//从root根元素寻找下面所有的book子元素
		List<Element> bookList = 
			root.elements("book");
		//循环bookList，访问book下面的name子元素
		for(Element book : bookList){
			Element name = 
				book.element("name");
			System.out.println(name.getText());
		}

	}
	

}
