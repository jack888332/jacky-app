package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/handlerForREST")
@Controller
public class HandlerForREST {
    // success.jsp 的JSTL行需要加上 isErrorPage="true",否则在转发时会报405
    private static final String SUCCESS = "others/success";

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRestGet(@PathVariable Integer id) {
        System.out.println("testRest GET:" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRestPost() {
        System.out.println("testRest POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("testRest DELETE:" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRest PUT:" + id);
        return SUCCESS;
    }
}
