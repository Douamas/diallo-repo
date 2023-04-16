package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmplouyeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmplouyeeDAOJpaImpl(EntityManager TheEntityManager) {
		this.entityManager = TheEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create query
		TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee findById(int employeeId) {

		// get employee
		Employee theEmployee = entityManager.find(Employee.class, employeeId);

		// return employee
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		
		// save employee
		Employee dbeEmployee = entityManager.merge(theEmployee);

		// get the dBemployee
		return dbeEmployee;
	}

	@Override
	public void deleteById(int employeeId) {
		
		// find employee by id 
		Employee theEmployee = entityManager.find(Employee.class, employeeId);
		
		// remove employee
		entityManager.remove(theEmployee);

	}

}
