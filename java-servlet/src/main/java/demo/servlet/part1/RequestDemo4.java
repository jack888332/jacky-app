package demo.servlet.part1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 请求转发案例
@WebServlet("/servlet4")
@SuppressWarnings("serial")
public class RequestDemo4 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet4");
		request.setAttribute("money", 10000); // 请求域数据（若干请求转发的共享数据）
		request.getRequestDispatcher("/servlet5").forward(request, response); // 转发不需要虚拟目录，因为都是访问服务器内部资源
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

}
