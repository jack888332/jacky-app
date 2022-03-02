package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/handlerForUploadFile")
public class HandlerForUploadFile {
    @RequestMapping("/uploadFile")
    public String uploadFile() {
        System.out.println("run uploadFile()");
        return "success";
    }
}
