package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDao) {
		this.employeeDao = theEmployeeDao;
	}

	@Override
	public List<Employee> findAll() {

		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		return employeeDao.findById(employeeId);
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		return employeeDao.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int employeeId) {
		employeeDao.deleteById(employeeId);
	}

}
