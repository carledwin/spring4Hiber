package com.carledwinj.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carledwinj.dao.EmployeeDAO;
import com.carledwinj.entity.Employee;
import com.carledwinj.util.HibernateUtil;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private HibernateUtil hibernateUtil;
	
	public EmployeeDAOImpl() {
		System.out.println("**** EmployeeImpl ****");
	}
	
	public long createEmployee(Employee e) {
		return  (Long) hibernateUtil.create(e);
	}

	public Employee updateEmployee(Employee e) {
		return hibernateUtil.update(e);
	}

	public void deleteEmployee(long id) {
		Employee e = new Employee();
		e.setId(id);
		hibernateUtil.delete(e);
	}

	public Employee getEmployee(long id) {
		return hibernateUtil.fetchById(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return hibernateUtil.fetchAll(Employee.class);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees(String name) {
		
		String query = " SELECT e.* FROM Employee e WHERE e.name like '%" + name + "%'";
		List<Object[]> list = hibernateUtil.fetchAll(query);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		for(Object[] e : list){
			Employee employee = new Employee();
			employee.setId(((BigInteger)e[0]).longValue());
			employee.setAge((Integer) e[1]);
			employee.setName((String) e[2]);
			//employee.setSalary(((float) e[3]));
			employees.add(employee);
		}
		return employees;
	}

}
