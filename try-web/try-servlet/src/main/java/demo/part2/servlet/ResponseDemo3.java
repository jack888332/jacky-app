package demo.part2.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/response-demo-3")
@SuppressWarnings("serial")
public class ResponseDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		// MIME类型：用于告诉浏览器当前数据的类型/格式，浏览器则采用相应的解析器解析数据
		String filename = "demo.jpg";
		String mineType = context.getMimeType(filename);
		System.out.println(mineType);

		// 设置域对象(ServletContext作用域：服务器运行的周期，任何用户任何连接任何动作都可访问该数据)
		context.setAttribute("data", "不告诉你");

		// 获取（已部署）文件在服务器内的真实路径
		String path1 = context.getRealPath("/demo.jsp");
		System.out.println(path1);
		String path2 = context.getRealPath("/WEB-INF/web.xml");
		System.out.println(path2);
		String path3 = context.getRealPath("/WEB-INF/classes/druid.properties");
		System.out.println(path3);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
