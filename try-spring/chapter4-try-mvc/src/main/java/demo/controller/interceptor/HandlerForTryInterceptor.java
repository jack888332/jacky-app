package demo.controller.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tryInterceptor")
public class HandlerForTryInterceptor {
    @RequestMapping("triggerInterceptor")
    public String triggerInterceptor() {
        System.out.println("triggerInterceptor()执行");
        return "common/success";
    }
}
