package part8.demo.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

// 验证过滤器的工作过程
//@WebFilter("/*")
public class FilterDemo3 implements Filter{
	
	// 服务器在启动后，会自动创建所有Filter对象，并调用init()
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilterDemo3 : init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 访问目标资源前，对request增强
		System.out.println("FilterDemo3执行");
		// 放行请求，访问目标资源
		chain.doFilter(request, response);
		// 访问目标资源后，对response增强
		System.out.println("FilterDemo3回来");
	}
	
	// 服务器在正常关闭后，会自动创建销毁Filter对象，并调用destroy()
	@Override
	public void destroy() {
		System.out.println("FilterDemo3 : destroy");
	}

}
