package demo.part6.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class FilterDemo2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo2已执行");
		chain.doFilter(request, response);
	}

}
