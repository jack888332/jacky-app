package demo.part6.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/filtersExecutionStack")
// 按类名的字符串比较规格，值较小的先执行
public class FilterDemo5 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo5");
		chain.doFilter(request, response);
		System.out.println("FilterDemo5");
	}

}
