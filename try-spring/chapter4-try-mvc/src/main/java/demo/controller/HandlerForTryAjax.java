package demo.controller;

import demo.mapper.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/handlerForTryAjax")
@Controller
public class HandlerForTryAjax {
    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User body) {
        System.out.println("已执行testAjax()");
        System.out.println(body);
        body.setUsername("李智杰");
        body.setId(3454353);
        return body;
    }
}
