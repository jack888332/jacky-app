package demo.servlet.part3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/setCookie")
@SuppressWarnings("serial")
public class BrowserCacheDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 一次会话是指：在同一个浏览器进程中，浏览器若干次访问服务器
		// Cookie是浏览器的会话(进程运行期间)缓存
		Cookie cookie1 = new Cookie("myName", "Jacky");
		Cookie cookie2 = new Cookie("myAge", "25");
		Cookie cookie3 = new Cookie("msg", "你好");
		cookie1.setMaxAge(300); // cookie1将持久化到硬盘，300秒后删除，浏览器若在300秒内重启，则自动加载cookie1
		cookie1.setPath("/"); // 所有项目共享cookie1
		cookie2.setPath("/web-servlet-another"); // 本项目和指定项目共享cookie2
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
