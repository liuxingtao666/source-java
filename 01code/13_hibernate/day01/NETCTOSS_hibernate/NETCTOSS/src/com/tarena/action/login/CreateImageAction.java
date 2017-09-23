package com.tarena.action.login;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.tarena.action.BaseAction;
import com.tarena.util.ImageUtil;

/**
 *	������֤��ͼƬ
 */
public class CreateImageAction 
	extends BaseAction {
	
	//output
	private InputStream imageStream;
	
	public String execute() {
		//����ͼƬ
		Map<String, BufferedImage> map = 
			ImageUtil.createImage();
		//ȡ����֤��
		String code = 
			map.keySet().iterator().next();
		//����֤�����session
		session.put("imageCode", code);
		//ȡ��ͼƬ
		BufferedImage image = map.get(code);
		try {
			//��ͼƬת��Ϊ������
			imageStream = 
				ImageUtil.getInputStream(image);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

}
