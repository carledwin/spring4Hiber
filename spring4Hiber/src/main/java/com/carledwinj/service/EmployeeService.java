package com.carledwinj.service;

import java.util.List;

import com.carledwinj.entity.Employee;

public interface EmployeeService {
	public long createEmployee(Employee e);
	public Employee updateEmployee(Employee e);
	public void deleteEmployee(long id);
	public Employee getEmployee(long id);
	public List<Employee> getAllemployees();
	public List<Employee> getAllEmployees(String name);
}
