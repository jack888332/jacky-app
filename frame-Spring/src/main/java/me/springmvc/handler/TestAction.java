package me.springmvc.handler;

import java.io.IOException;
import java.io.Writer;

import me.springmvc.vo.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/testAction")
@Controller
public class TestAction {
	private static final String SUCCESS = "test/success";

	@RequestMapping("/requestParam")
	public String testRequestParam(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "age", required = false) Integer age) {
		System.out.println("【RequestParam】username：" + username + "，age：" + age);
		return SUCCESS;
	}

	@RequestMapping("/requestHeader")
	public String testRequestHeader(
			@RequestHeader(value = "Accept-Language") String al) {
		System.out.println("【RequestHeader】Accept-Language：" + al);
		return SUCCESS;
	}

	@RequestMapping("/cookieValue")
	public String testCookieValue(
			@CookieValue(value = "JSESSIONID") String sessionId) {
		System.out.println("【CookieValue】JSESSIONID：" + sessionId);
		return SUCCESS;
	}

	@RequestMapping("/userForm")
	public String testActionForm(User user) {
		System.out.println("【Pojo】" + user);
		return SUCCESS;
	}
	
	@RequestMapping("/servletAPI")
	public void testServletAPI(HttpServletRequest request,
			HttpServletResponse response, Writer out) throws IOException {
		System.out.println("【ServletAPI】" + request + "," + response);
		out.write("hello springmvc");
	}
	
	@RequestMapping("/redirect")
	public String testRedirect() {
		System.out.println("testRedirect");
		return "redirect:/redirect.jsp";
	}

}
