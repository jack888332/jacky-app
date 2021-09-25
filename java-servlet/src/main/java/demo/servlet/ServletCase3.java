package demo.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet3")
public class ServletCase3 extends HttpServlet {
	private static final long serialVersionUID = 1220378139052786465L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 获取指定请求参数
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));		
		
		// 遍历所有请求参数
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = parameterNames.nextElement();
			for (String parameterValue : request.getParameterValues(parameterName)) {
				System.out.println(parameterName + " : " + parameterValue);
			}
		}

		// 遍历所有请求参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<String> pNames = parameterMap.keySet();
		for (String pName : pNames) {
			for (String pValue : parameterMap.get(pName)) {
				System.out.println(pName + " : " + pValue);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
