package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("router")
@Controller
public class Router {
    /**
     * @return 转发 try-ajax.jsp
     */
    @RequestMapping("try-REST")
    public String gotoRest() {
        return "others/try-REST";
    }

    @RequestMapping("/gotoActionForm")
    public String gotoActionForm() {
        return "test/actionForm";
    }

    @RequestMapping("/gotoModelData")
    public String gotoModelData() {
        return "test/modelDataIndex";
    }

    @RequestMapping("/jstlView")
    public String jstlView() {
        return "test/success";
    }

    @RequestMapping("/customView")
    public String customView() {
        return "customView";
    }

    /**
     *
     */
    @RequestMapping("/crud")
    public String gotoProject() {
        return "project/home";
    }

    /**
     * @return 转发 try-ajax.jsp
     */
    @RequestMapping("try-ajax")
    public String dispatchResource_9() {
        return "others/try-ajax";
    }

    /**
     * @return 转发 try-upload.jsp
     */
    @RequestMapping("try-upload")
    public String dispatchResource_10() {
        return "others/try-upload";
    }
}
