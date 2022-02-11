package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import domain.Employee;
import repository.DepartmentDao;
import repository.EmployeeDao;

import java.util.Map;

@RequestMapping("employeeAction")
@Controller
public class EmployeeAction {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping("/emps")
	public String list(Map<String, Object> modelMap) {
		modelMap.put("employees", employeeDao.getAll());
		return "project/list";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> modelMap) {
		modelMap.put("employee", new Employee());
		modelMap.put("departments", departmentDao.getDepartments());
		return "project/input";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String save(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/employeeAction/emps";
	}
	
/*	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String save(@Valid Employee employee, Errors result, 
			Map<String, Object> map){
		System.out.println("save: " + employee);
		
		if(result.getErrorCount() > 0){
			System.out.println("������!");
			
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			
			//����֤����, ��ת���Ƶ�ҳ��
			map.put("departments", departmentDao.getDepartments());
			return "project/input";
		}
		
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "project/input";
	}
	
	@RequestMapping("/emps")
	public String list(Map<String, Object> map){
		map.put("employees", employeeDao.getAll());
		return "project/list";
	}*/

}
