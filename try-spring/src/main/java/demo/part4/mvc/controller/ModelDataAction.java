package demo.part4.mvc.controller;

import domain.Address;
import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

// @SessionAttribute上只能放在类上
@SessionAttributes(value = { "user","time" }, types = { String.class })
@RequestMapping("/modelDateAction")
@Controller
public class ModelDataAction {
	private static final String SUCCESS = "test/modelData";
	
	private Address address = new Address("guangdong", "guangzhou");

	@RequestMapping("/modelAndView")
	public ModelAndView testModelAndView() {
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		// 把模型数据添加到ModelAndView中
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}

	// 入参除了Map，还可以是Model或ModelMap
	@RequestMapping("/modelMap")
	public String testModelMap(Map<String, Object> modelMap) {
		modelMap.put("name", Arrays.asList("jack", "mike", "rose"));
		return SUCCESS;
	}
	
	// 把数据放进Session中
	@RequestMapping("/sessionAttributes")
	public String testSessionAttributes(Map<String, Object> modelMap) {
		modelMap.put("user", new User(1, "Jack", "123456", address));
		modelMap.put("school", "home");
		return SUCCESS; 
	}
	
	@RequestMapping("/modelAttribute")
	public String testModelAttribute(@ModelAttribute("user") User uf) {
		System.out.println("修改：" + uf);
		return SUCCESS;
	}

	/**
	 * 运行流程：
	 * 1. 执行@ModelAttribute修饰的方法，从数据库中取出队形，把对象放入Map中
	 * 2. SpringMVC从Map中取出User对象，并表单的请求参数赋给该User对象的属性
	 * 3. SpringMVC把上述对象传入目标方法的参数
	 */
	@ModelAttribute
	public void getDataFromDB(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> modelMap) {
		if (id != null) {
			// 模拟从数据库中获取对象
			User user = new User(1, "jack", "123456", address);
			System.out.println("从数据库中获取：" + user);
			modelMap.put("user", user);
		}
	}
}
