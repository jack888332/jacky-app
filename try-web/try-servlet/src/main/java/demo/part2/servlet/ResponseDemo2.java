package demo.part2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.Charset;

@WebServlet("/response-demo-2")
@SuppressWarnings("serial")
public class ResponseDemo2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 告诉浏览器以UTF-8解码
		response.setContentType("text/html; charset=UTF-8");
		// 填充响应字节输出流
		ServletOutputStream sos = response.getOutputStream();
		sos.write("Hello".getBytes());
		try {
			Class<?> clazz = Class.forName("sun.nio.cs.UTF_8");
			Charset charset = (Charset) clazz.getDeclaredConstructor().newInstance();
			System.out.println(charset.name());
			sos.write("你好".getBytes(charset));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
