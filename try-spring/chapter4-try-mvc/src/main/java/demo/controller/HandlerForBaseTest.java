package demo.controller;

import demo.mapper.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@RequestMapping("/handlerForBaseTest")
@Controller
public class HandlerForBaseTest {
    private static final String SUCCESS = "dynamic-resource/pages/success";

    @RequestMapping("/requestParam")
    public String testRequestParam(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "age", required = false) Integer age) {
        System.out.println("【RequestParam】username：" + username + "，age：" + age);
        return SUCCESS;
    }

    @RequestMapping("/requestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
        System.out.println("【RequestHeader】Accept-Language：" + al);
        return SUCCESS;
    }

    @RequestMapping("/cookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String sessionId) {
        System.out.println("【CookieValue】JSESSIONID：" + sessionId);
        return SUCCESS;
    }

    @RequestMapping("/userForm")
    public String testActionForm(User user) {
        System.out.println("【Pojo】" + user);
        return SUCCESS;
    }

    // 原生Servlet
    @RequestMapping("/servletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out)
            throws IOException {
        System.out.println("【ServletAPI】" + request + "," + response);
        out.write("hello springmvc");
    }

    @RequestMapping("/redirect")
    public String testRedirect() {
        System.out.println("testRedirect");
        return "redirect:/redirect.jsp";
    }

    @RequestMapping("/responseJsonForAjax")
    public @ResponseBody User responseJsonForAjax(@RequestBody User user) {
        // @RequestBody 把请求体的json转化为User
        // @ResponseBody 把返回值转化为json
        user.setUsername("KKKK");
        user.setPassword("BBBB");
        return user;
    }

}