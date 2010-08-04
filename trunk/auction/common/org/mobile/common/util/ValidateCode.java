/*
 * 验证码生成工具类
 */
package org.mobile.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.mobile.common.bean.ValidateCodeBean;
import org.mobile.common.exception.GeneralException;

/**
 * 
 * @author 孙树林
 * 
 */
public class ValidateCode {

	/** 生成验证码需要的字符 */
	private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9' };

	private ValidateCode() {
	}

	/**
	 * 生成验证码
	 * 
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @param codeCount
	 *            显示字符个数
	 * @throws GeneralException
	 */
	public static ValidateCodeBean codeGeneration(int width, int height,
			int codeCount) throws GeneralException {
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = buffImg.createGraphics();

		// 创建一个随机数生成器类
		Random random = new Random();

		// 将图像填充为白色
		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(0, 0, width, height);

		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Fixedsys", Font.PLAIN, height - 2);
		// 设置字体。
		graphics2D.setFont(font);

		// 画边框。
		graphics2D.setColor(Color.BLACK);
		graphics2D.drawRect(0, 0, width - 1, height - 1);

		// 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
		graphics2D.setColor(Color.BLACK);
		for (int i = 0; i < 160; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			graphics2D.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;

		// 随机产生 codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);

			// 用随机产生的颜色将验证码绘制到图像中。
			graphics2D.setColor(new Color(red, green, blue));
			graphics2D.drawString(strRand, (i + 1) * width / (codeCount + 1),
					height - 4);

			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
		ValidateCodeBean bean = new ValidateCodeBean();
		bean.setBuffImg(buffImg);
		bean.setCode(randomCode.toString());
		return bean;
	}
}
