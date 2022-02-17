package controller.module.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserCenterService;
import service.impl.UserCenterServiceImpl;

import java.io.IOException;

@WebServlet({ "/user-center", "/add-user" })
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserCenterService ucs = new UserCenterServiceImpl();
		HttpSession session = request.getSession();
		session.setAttribute("users", ucs.getAllUsers());
		response.sendRedirect(request.getContextPath() + "/view/user-center.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}