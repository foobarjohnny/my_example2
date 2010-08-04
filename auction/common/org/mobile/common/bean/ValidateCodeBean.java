/*
 * 验证码Bean
 */
package org.mobile.common.bean;

import java.awt.image.BufferedImage;

/**
 * 生成验证码
 * 
 * @author 孙树林
 * 
 */
public class ValidateCodeBean {

	/** 生成的验证码 */
	private String code;
	/** 生成的图像 */
	private BufferedImage buffImg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BufferedImage getBuffImg() {
		return buffImg;
	}

	public void setBuffImg(BufferedImage buffImg) {
		this.buffImg = buffImg;
	}

}
