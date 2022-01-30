package demo.servlet.part2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 测试响应字符输出流
 */
@WebServlet("/response-demo-1")
@SuppressWarnings("serial")
public class ResponseDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 输出流以UTF-8编码
		System.out.println("字符编码：" + request.getCharacterEncoding());
		response.setCharacterEncoding("UTF-8");
		// 告诉浏览器以UTF-8解码
		// response.setHeader("content-type", "text/html; charset=UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 填充字符输出流
		PrintWriter pw = response.getWriter();
		pw.write("<h1>欢迎来到完美世界</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
