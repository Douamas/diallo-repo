package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	Employee findById(int employeeId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int employeeId);
	

}
