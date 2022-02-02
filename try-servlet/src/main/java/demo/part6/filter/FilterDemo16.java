package demo.part6.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/filtersExecutionStack")
public class FilterDemo16 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo16");
		chain.doFilter(request, response);
		System.out.println("FilterDemo16");
	}

}
