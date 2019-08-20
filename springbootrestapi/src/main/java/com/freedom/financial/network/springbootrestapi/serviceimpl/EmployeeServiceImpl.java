package com.freedom.financial.network.springbootrestapi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freedom.financial.network.springbootrestapi.exceptions.DatabaseException;
import com.freedom.financial.network.springbootrestapi.model.Employee;
import com.freedom.financial.network.springbootrestapi.repository.EmployeeRepository;
import com.freedom.financial.network.springbootrestapi.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	 private EmployeeRepository employeeRepository;
	 
	 public void setEmployeeRepository(EmployeeRepository employeeRepository) {
	  this.employeeRepository = employeeRepository;
	 }
	 
	 /**
	  * This method is used to retrieve the employee information from the system
	  */
	 
	 public List<Employee> retrieveEmployees() throws DatabaseException{
	  List<Employee> employees = employeeRepository.findAll();
	  return employees;
	 }
	 
	 /**
	  * This method is used to get the particular employee information from the system
	  */
	  
	 public Employee getEmployee(Long employeeId) throws DatabaseException{
	  Optional<Employee> optEmp = employeeRepository.findById(employeeId);
	  return optEmp.get();
	 }
	 
	 /**
	  * This method is used to persist the information in the system
	  */
	  
	 public void saveEmployee(Employee employee) throws DatabaseException{
	  employeeRepository.save(employee);
	 }
	 
	 /**
	  * This method is used to delete the particular employee from the system
	  */
	  
	 public void deleteEmployee(Long employeeId) throws DatabaseException{
	  employeeRepository.deleteById(employeeId);
	 }
	 
	 /**
	  * This method is used to update the particular information of employee in the system
	  */
	  
	 public void updateEmployee(Employee employee) throws DatabaseException{
	  employeeRepository.save(employee);
	 }
	 
	 public void patchEmployee(Employee employee) throws DatabaseException{
		  employeeRepository.save(employee);
		 }
	
}
