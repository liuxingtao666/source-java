package action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;

/**
 *	�ϴ��ļ�
 */
public class UploadAction {

	//input
	/*
	 * �ϴ����ļ����������������롣
	 * ���������������ʱ�ļ���
	 * */
	private File some;
	/*
	 * ��������"�ļ�������+FileName"��
	 * ���Խ��������������ԭʼ�ļ�����
	 * */
	private String someFileName;
	
	/**
	 * ����ʱ�ļ����Ƶ�һ���̶���·����
	 */
	public String execute() {
		if(some == null) {
			//����ϴ�ʧ�ܣ����ļ�Ϊ��
			return "error";
		}
		//ָ�����·��������ڵ�ǰ�������Ŀ·��
		String path = "WEB-INF/upload/"
			+ someFileName;
		//�������·�������������·��
		path = ServletActionContext
			.getServletContext()
			.getRealPath(path);
		//����ʱ�ļ����Ƶ�ָ��·����
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
