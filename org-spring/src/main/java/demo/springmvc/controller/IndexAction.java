package demo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("indexAction")
@Controller
public class IndexAction {

	@RequestMapping("/gotoRest")
	public String gotoRest() {
		return "test/rest";
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
	
	@RequestMapping("/crud")
	public String gotoProject() {
		System.out.println("222");
		return "project/home";
	}
}
