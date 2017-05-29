package com.carledwinj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.carledwinj.dao.EmployeeDAO;
import com.carledwinj.entity.Employee;
import com.carledwinj.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	public EmployeeServiceImpl() {
		System.out.println("**** EmployeeServiceImpl **** ");
	}
	
	public long createEmployee(Employee e) {
		return dao.createEmployee(e);
	}

	public Employee updateEmployee(Employee e) {
		return dao.updateEmployee(e);
	}

	public void deleteEmployee(long id) {
		dao.deleteEmployee(id);
	}

	public Employee getEmployee(long id) {
		return dao.getEmployee(id);
	}

	public List<Employee> getAllemployees() {
		return dao.getAllEmployees();
	}

	public List<Employee> getAllEmployees(String name) {
		return getAllEmployees(name);
	}

}
