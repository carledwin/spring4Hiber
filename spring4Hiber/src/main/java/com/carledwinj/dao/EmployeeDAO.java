package com.carledwinj.dao;

import java.util.List;

import com.carledwinj.entity.Employee;

public interface EmployeeDAO {
	public long createEmployee(Employee e);
	public Employee updateEmployee(Employee e);
	public void deleteEmployee(long id);
	public Employee getEmployee(long id);
	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployees(String name);
}
