package com.carledwinj.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carledwinj.entity.Employee;
import com.carledwinj.service.EmployeeService;

@Controller
public class EmployeeController {

	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService service;
	
	public EmployeeController() {
		System.out.println("**** EmployeeController ****");
	}

	@RequestMapping("createEmployee")
	public ModelAndView createEmployee(@ModelAttribute Employee employee){
		logger.info("Creating Employee. Data: " + employee);
		return new ModelAndView("employeeForm");
	}
	
	@RequestMapping("editEmployee")
	public ModelAndView editEmployee(@RequestParam long id, @ModelAttribute Employee employee ){
		logger.info("Updating the Employee for the Id " + id);
		employee = service.getEmployee(id);
		return new ModelAndView("employeeForm", "employeeObject", employee);
	}
	
	@RequestMapping("saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee){
		logger.info("Saving the Employee. Data: " + employee);
		if(employee.getId() == 0){
			service.createEmployee(employee);
		}else {
			service.updateEmployee(employee);
		}
		return new ModelAndView("redirect:getAllEmployees");
	}
	
	@RequestMapping("deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam long id){
		logger.info("Deleting the Employee. Id: " + id);
		service.deleteEmployee(id);
		return new ModelAndView("redirect:getallEmployees");
	}
	
	@RequestMapping(value={"getAllEmployees", "/"})
	public ModelAndView getAllEmployees(){
		logger.info("Getting the all Employees.");
		List<Employee> employeeList =
				service.getAllemployees();
		return new ModelAndView("employeeList", "employeeList", employeeList);
	}
	
	@RequestMapping("searchEmployee")
	public ModelAndView searchEmployee(@RequestParam("searchName") String searchName){
		logger.info("Searching the Employee. Employee Names: " + searchName);
		List<Employee> employeeList = service.getAllEmployees(searchName);
		return new ModelAndView("employeeList", "employeeList", employeeList);
	}
}
