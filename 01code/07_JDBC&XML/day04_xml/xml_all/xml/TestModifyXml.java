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
		//��������������
		SAXReader reader = new SAXReader();
		//��ȡsrc/xml/test01.xml,����doc�ĵ�������
		File file = new File("src/xml/test01.xml");
		Document doc = reader.read(file);
		Element depts = 
			doc.getRootElement();
		//ΪdeptsԪ�����һ����Ԫ��
		Element newdept = 
			depts.addElement("dept");
		//Ϊnewdept���name��loc��Ԫ��
		Element newname = 
			newdept.addElement("name");
		newname.setText("���Բ�");
		Element newloc = 
			newdept.addElement("loc");
		newloc.setText("�Ϻ�");
		//���ڴ��е�doc�ĵ�������xml�ļ�ͬ��
		FileOutputStream fos = 
			new FileOutputStream(file);
//		OutputFormat,����������
		XMLWriter writer = 
				new XMLWriter(fos);
		writer.write(doc);
		writer.flush();
		writer.close();
	}
	
	public static void testDel() throws Exception{
		//��������������
		SAXReader reader = new SAXReader();
		//��ȡsrc/xml/test01.xml,����doc�ĵ�������
		File file = new File("src/xml/test01.xml");
		Document doc = reader.read(file);
		Element depts = 
			doc.getRootElement();
		//����xpath��λname=��������dept
		Element dept = (Element)
			doc.selectSingleNode(
			"//dept[name='������']");
		//��depts�н�dept�Ƴ�
		depts.remove(dept);
		
		//���ڴ��е�doc�ĵ�������xml�ļ�ͬ��
		FileOutputStream fos = 
			new FileOutputStream(file);
//		OutputFormat,����������
		XMLWriter writer = 
				new XMLWriter(fos);
		writer.write(doc);
		writer.flush();
		writer.close();
	}
	
	

}
