package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandlerForViewResolver {
	private static final String SUCCESS = "success";
	
	@RequestMapping("/viewAndViewResolver")
	public String testViewAndViewResolver() {
		System.out.println("viewAndViewResolver");
		return SUCCESS;
	}
}

