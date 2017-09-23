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
		//step1,创建DiskFileItemFactory对象,
		//该对象为解析器提供解析时的一些缺省配置。
		DiskFileItemFactory dfif = 
			new DiskFileItemFactory();
		//step2,创建一个解析器
		ServletFileUpload sfu = 
			new ServletFileUpload(dfif);
		//step3,解析
		//解析器会分析
		//InputStream,然后将解析的结果
		//封装到相应的FileItem对象里面(
		//一个表单域对应一个FileItem)。
		try {
			//只需要调用FileItem对象的方法就可以
			//获得表单中的数据。
			List<FileItem> items = 
				sfu.parseRequest(request);
			for(int i=0;i<items.size();i++){
				FileItem item = items.get(i);
				if(item.isFormField()){
					//这是一个普通的表单域
					//(不是上传文件域)
					//获得参数名
					String fieldName = item.getFieldName();
					System.out.println(fieldName);
					//获得参数值
					String username = item.getString();
					System.out.println(username);
				}else{
					//这是一个上传文件域
					ServletContext sctx = 
						getServletContext();
					//依据逻辑路径获得实际部署时的物理路径
					String path = sctx.getRealPath("upload");
					System.out.println(path);
					//获得上传文件的名称
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
