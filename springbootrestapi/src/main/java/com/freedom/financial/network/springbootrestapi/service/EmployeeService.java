package com.freedom.financial.network.springbootrestapi.service;

import java.util.List;

import com.freedom.financial.network.springbootrestapi.exceptions.DatabaseException;
import com.freedom.financial.network.springbootrestapi.model.Employee;

public interface EmployeeService {
	
	/**
	 * 
	 * @return
	 */
	
	public List<Employee> retrieveEmployees() throws DatabaseException;
	
	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	  
	 public Employee getEmployee(Long employeeId) throws DatabaseException;
	 
	 /**
	  * 
	  * @param employee
	  */
	  
	 public void saveEmployee(Employee employee) throws DatabaseException;
	 
	 /**
	  * 
	  * @param employeeId
	  */
	  
	 public void deleteEmployee(Long employeeId) throws DatabaseException;
	 
	 /**
	  * 
	  * @param employee
	  */
	  
	 public void updateEmployee(Employee employee) throws DatabaseException;
	 
	 /**
	  * 
	  * @param employee
	  */
	 
	 public void patchEmployee(Employee employee) throws DatabaseException;

}
