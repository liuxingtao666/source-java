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
		//����test02.xml�����ĵ�������
		SAXReader reader = new SAXReader();
		Document doc = reader.read(
			new File("src/xml/test02.xml"));
		//����xpath���ٶ�λname=�����˲���bookԪ��
		Element book = (Element)
			doc.selectSingleNode(
			"//book[name='�����˲�']");
		//��ȡbook��price��Ԫ��ֵ
		String price = 
			book.element("price").getText();
		System.out.println(price);
	}

}
