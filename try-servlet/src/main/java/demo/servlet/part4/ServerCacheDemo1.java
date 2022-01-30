package demo.servlet.part4;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/setSession1")
@SuppressWarnings("serial")
public class ServerCacheDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Session为服务器的会话缓存，依赖于Cookie
		// 响应头 set-cook:JSESSIONID=XXX
		// 请求头 cookie:JSESSIONID=XXX
		HttpSession session = request.getSession();
		session.setAttribute("info1", "Jack");
		session.setAttribute("info2", "Rose");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}