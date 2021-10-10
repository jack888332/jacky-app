package interaction.login;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.User;
import model.business_logic.LoginService;
import model.business_logic.impl.LoginServiceImpl;
import view.bean.LoginForm;

@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码
		request.setCharacterEncoding("UTF-8");
		// 2.获取请求参数
		LoginForm info = new LoginForm();
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(info, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3.从session中获取刚生成的验证码
		HttpSession session = request.getSession();
		String checkcode = (String) session.getAttribute("checkcode");
		session.removeAttribute("checkcode");

		// 4.忽略大小写比较验证码
		if (checkcode != null && checkcode.equalsIgnoreCase(info.getCheckcode())) {
			LoginService loginService = new LoginServiceImpl();
			User user = loginService.checkLoginInfo(info);
			if (user == null) {
				request.getRequestDispatcher("/view/common/error.jsp").forward(request, response);
			} else {
				// 登录成功
				request.setAttribute("user", user.toString());
				request.getRequestDispatcher("/user-center").forward(request, response);
			}
		} else {
			request.setAttribute("error-1", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
