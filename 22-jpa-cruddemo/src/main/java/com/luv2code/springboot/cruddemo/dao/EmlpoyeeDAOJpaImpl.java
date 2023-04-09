package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class EmlpoyeeDAOJpaImpl implements EmployeeDAO {
	
	
	private EntityManager entitymanager;
	
	

	public EmlpoyeeDAOJpaImpl(EntityManager theEntitymanager) {
		entitymanager = theEntitymanager;
	}

	@Override
	public List<Employee> findAll() {

		// create query
		
		Query theQuery = entitymanager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// get employee
		Employee theEmployee = entitymanager.find(Employee.class, theId);
		
		// return employe
		return theEmployee;
		
	}

	@Override
	public void save(Employee theEmployee) {
		// save or update the Employee
		Employee dbEmployee = entitymanager.merge(theEmployee);
		
		// update with id from db ... so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
		

	}

	@Override
	public void deleteById(int theId) {
		// delete object with primary key
		Query theQuery = entitymanager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
