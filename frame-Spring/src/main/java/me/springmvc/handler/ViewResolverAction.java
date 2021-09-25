package me.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewResolverAction {
	private static final String SUCCESS = "success";
	
	@RequestMapping("/viewAndViewResolver")
	public String testViewAndViewResolver() {
		System.out.println("viewAndViewResolver");
		return SUCCESS;
	}
}

