package action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;

/**
 *	上传文件
 */
public class UploadAction {

	//input
	/*
	 * 上传的文件，由拦截器负责传入。
	 * 拦截器传入的是临时文件。
	 * */
	private File some;
	/*
	 * 定义属性"文件属性名+FileName"，
	 * 可以接收拦截器传入的原始文件名。
	 * */
	private String someFileName;
	
	/**
	 * 将临时文件复制到一个固定的路径下
	 */
	public String execute() {
		if(some == null) {
			//如果上传失败，则文件为空
			return "error";
		}
		//指定相对路径，相对于当前部署的项目路径
		String path = "WEB-INF/upload/"
			+ someFileName;
		//根据相对路径，计算出完整路径
		path = ServletActionContext
			.getServletContext()
			.getRealPath(path);
		//将临时文件复制到指定路径下
		FileUtil.copy(some, new File(path));
		return "success";
	}
	
	public String getSomeFileName() {
		return someFileName;
	}

	public void setSomeFileName(String someFileName) {
		this.someFileName = someFileName;
	}

	public File getSome() {
		return some;
	}

	public void setSome(File some) {
		this.some = some;
	}
	
}
