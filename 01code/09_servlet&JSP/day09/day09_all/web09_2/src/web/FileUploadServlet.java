package web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//step1,����DiskFileItemFactory����,
		//�ö���Ϊ�������ṩ����ʱ��һЩȱʡ���á�
		DiskFileItemFactory dfif = 
			new DiskFileItemFactory();
		//step2,����һ��������
		ServletFileUpload sfu = 
			new ServletFileUpload(dfif);
		//step3,����
		//�����������
		//InputStream,Ȼ�󽫽����Ľ��
		//��װ����Ӧ��FileItem��������(
		//һ�������Ӧһ��FileItem)��
		try {
			//ֻ��Ҫ����FileItem����ķ����Ϳ���
			//��ñ��е����ݡ�
			List<FileItem> items = 
				sfu.parseRequest(request);
			for(int i=0;i<items.size();i++){
				FileItem item = items.get(i);
				if(item.isFormField()){
					//����һ����ͨ�ı���
					//(�����ϴ��ļ���)
					//��ò�����
					String fieldName = item.getFieldName();
					System.out.println(fieldName);
					//��ò���ֵ
					String username = item.getString();
					System.out.println(username);
				}else{
					//����һ���ϴ��ļ���
					ServletContext sctx = 
						getServletContext();
					//�����߼�·�����ʵ�ʲ���ʱ������·��
					String path = sctx.getRealPath("upload");
					System.out.println(path);
					//����ϴ��ļ�������
					String fileName = item.getName();
					System.out.println(fileName);
					File file = new File(path + 
							File.separator + fileName);
					item.write(file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
