package com.tarena.action.login;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.tarena.action.BaseAction;
import com.tarena.util.ImageUtil;

/**
 *	生成验证码图片
 */
public class CreateImageAction 
	extends BaseAction {
	
	//output
	private InputStream imageStream;
	
	public String execute() {
		//生成图片
		Map<String, BufferedImage> map = 
			ImageUtil.createImage();
		//取出验证码
		String code = 
			map.keySet().iterator().next();
		//将验证码存入session
		session.put("imageCode", code);
		//取出图片
		BufferedImage image = map.get(code);
		try {
			//将图片转化为输入流
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
