package xml;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class TestModifyXml {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		testAdd();
		testDel();
	}
	
	public static void testAdd() throws Exception{
		//创建解析器对象
		SAXReader reader = new SAXReader();
		//读取src/xml/test01.xml,构建doc文档树对象
		File file = new File("src/xml/test01.xml");
		Document doc = reader.read(file);
		Element depts = 
			doc.getRootElement();
		//为depts元素添加一个子元素
		Element newdept = 
			depts.addElement("dept");
		//为newdept添加name和loc子元素
		Element newname = 
			newdept.addElement("name");
		newname.setText("测试部");
		Element newloc = 
			newdept.addElement("loc");
		newloc.setText("上海");
		//将内存中的doc文档对象与xml文件同步
		FileOutputStream fos = 
			new FileOutputStream(file);
//		OutputFormat,解决输出乱码
		XMLWriter writer = 
				new XMLWriter(fos);
		writer.write(doc);
		writer.flush();
		writer.close();
	}
	
	public static void testDel() throws Exception{
		//创建解析器对象
		SAXReader reader = new SAXReader();
		//读取src/xml/test01.xml,构建doc文档树对象
		File file = new File("src/xml/test01.xml");
		Document doc = reader.read(file);
		Element depts = 
			doc.getRootElement();
		//利用xpath定位name=开发部的dept
		Element dept = (Element)
			doc.selectSingleNode(
			"//dept[name='开发部']");
		//从depts中将dept移除
		depts.remove(dept);
		
		//将内存中的doc文档对象与xml文件同步
		FileOutputStream fos = 
			new FileOutputStream(file);
//		OutputFormat,解决输出乱码
		XMLWriter writer = 
				new XMLWriter(fos);
		writer.write(doc);
		writer.flush();
		writer.close();
	}
	
	

}
