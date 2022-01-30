package demo.servlet.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/servlet2", "/jackyServlet" })
@SuppressWarnings("serial")
public class RequestDemo2 extends HttpServlet {
	// HttpServletRequest 和 HttpServletResponse 由 Tomcat 创建
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求行
		System.out.println("请求方法：" + request.getMethod());
		System.out.println("协议：" + request.getProtocol());
		System.out.println("请求IP：" + request.getRemoteAddr());
		System.out.println("URL：" + request.getRequestURL());
		System.out.println("URI：" + request.getRequestURI());
		System.out.println("虚拟目录：" + request.getContextPath());
		System.out.println("请求字串：" + request.getQueryString());

		// 获取所有请求头
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			Enumeration<String> headerValues = request.getHeaders(headerName);
			while (headerValues.hasMoreElements()) {
				System.out.println(headerName + " : " + headerValues.nextElement());
			}
		}

		// 根据浏览器做处理
		String userAgent = request.getHeader("user-agent");
		if (userAgent.contains("Chrome")) {
			System.out.println("这是 Chrome 浏览器");
		}

		// 防止盗链接
		String referer = request.getHeader("referer");
		if (null == referer) {
			System.out.println("无超链接访问");
		} else {
			System.out.println(referer);
		}

		// 获取请求体
		BufferedReader br = request.getReader();
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
