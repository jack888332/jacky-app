package demo.part4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/getSession2")
@SuppressWarnings("serial")
public class ServerCacheDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 默认情况下，对于服务器和浏览器之间的不同会话，服务器建立不同的session对象。
		HttpSession session = request.getSession();
		System.out.println(session);
		// 以下实现了：服务器能通过请求头的 Set-Cookie:JSESSIONID=XXX 来找到上一次会话的session对象。
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 60);
		response.addCookie(cookie);
		
		// 当服务器正常关闭时，服务器会把当前的session对象序列化到work目录中（钝化过程）
		// 当服务器重新启动时，服务器又从work目录反序列化session对象，并删除之前的序列化文件（活化过程）
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}