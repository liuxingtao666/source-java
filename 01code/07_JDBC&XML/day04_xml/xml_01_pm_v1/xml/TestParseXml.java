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
		//��������������
		SAXReader reader = new SAXReader();
		//��ȡsrc/xml/test02.xml,����doc�ĵ�������
		Document doc = reader.read(
			new File("src/xml/test02.xml"));
		//��ȡdoc���ĸ�Ԫ��
		Element root = 
			doc.getRootElement();
		//��root��Ԫ��Ѱ���������е�book��Ԫ��
		List<Element> bookList = 
			root.elements("book");
		//ѭ��bookList������book�����name��Ԫ��
		for(Element book : bookList){
			Element name = 
				book.element("name");
			System.out.println(name.getText());
		}

	}
	

}
