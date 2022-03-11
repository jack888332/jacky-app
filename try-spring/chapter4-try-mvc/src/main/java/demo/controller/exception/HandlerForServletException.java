package demo.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/handleServletException")
public class HandlerForServletException {
    @RequestMapping("/happenException")
    private String happenException() throws AnyException {
        System.out.println("call happenException()");
        try {
            int num = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AnyException("系统发生故障");
        }
        return "common/success";
    }
}
