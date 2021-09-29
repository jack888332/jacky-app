package demo.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//重定向
@WebServlet("/servlet6")
@SuppressWarnings("serial")
public class ServletCase6 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet6");
		String resourcePath = req.getContextPath() + "/servlet5";
		// sendRedirect(resp,resourcePath);
		resp.sendRedirect(resourcePath); //
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private void sendRedirect(HttpServletResponse resp, String resourcePath) {
		resp.setStatus(302);
		resp.setHeader("location", "/servlet5");
	}
}
