package demo.part5.mixcode.login2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/exercise-login2/checkcode")
@SuppressWarnings("serial")
public class CheckCode extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 120, height = 40;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		// 使图形和文本抗锯齿
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		// 绘制背景
		g2d.setColor(new Color(240, 220, 200, 255)); // 设置上下文颜色
		g2d.fillRect(0, 0, width, height);
		// 绘制边框
		g2d.setColor(Color.RED);
		g2d.drawRect(0, 0, width - 1, height - 1);
		// 绘制验证码
		g2d.setColor(Color.MAGENTA);
		g2d.setFont(new Font("Microsoft YaHei UI", Font.CENTER_BASELINE, 16));
		String candidate = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer checkcode = new StringBuffer();
		for (int i = 1; i < 5; i++) {
			char ch = candidate.charAt(random.nextInt(candidate.length()));
			g2d.drawString(Character.toString(ch), width / 5 * i, height / 2);
			checkcode.append(ch);
		}
		// 把验证码存在session中
		HttpSession session = request.getSession();
		session.setAttribute("checkcode", checkcode.toString());

		// 绘制干扰线
		g2d.setColor(Color.CYAN);
		for (int i = 0; i < 6; i++) {
			int anchor1_x = random.nextInt(width), anchor1_y = random.nextInt(height);
			int anchor2_x = random.nextInt(width), anchor2_y = random.nextInt(height);
			g2d.drawLine(anchor1_x, anchor1_y, anchor2_x, anchor2_y);
		}

		// 为图片指定格式，放到输出流
		ImageIO.write(image, "png", response.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Test
	public void testFont() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		for (Font font : ge.getAllFonts()) {
			System.out.println(font.getFamily());
		}
	}
}
