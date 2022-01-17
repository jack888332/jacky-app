package part8.demo.filter;

import java.io.IOException;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/demo.jsp", dispatcherTypes = DispatcherType.FORWARD)
public class FilterDemo4 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("当转发方式访问demo.jsp时，FilterDemo4被执行；直接访问demo.jsp不会执行");
		chain.doFilter(request, response);
	}

}
