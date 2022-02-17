package demo.part6.filter;

import jakarta.servlet.*;

import java.io.IOException;

/*@WebFilter("/*") *///访问所有/特定资源时，过滤器自动执行
public class FilterDemo1 implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo1已执行");
		// 放行
		chain.doFilter(request, response);
	}

}
