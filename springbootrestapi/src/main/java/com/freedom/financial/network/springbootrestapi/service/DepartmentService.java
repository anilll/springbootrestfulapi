package com.freedom.financial.network.springbootrestapi.service;

import java.util.List;

import com.freedom.financial.network.springbootrestapi.exceptions.DatabaseException;
import com.freedom.financial.network.springbootrestapi.model.Department;

public interface DepartmentService {
	
	/**
	 * 
	 * @return
	 */
	
	public List<Department> retrieveDepartments() throws DatabaseException;
	
	/**
	 * 
	 * @param deptId
	 * @return
	 */
	  
	 public Department getDepartment(Long deptId) throws DatabaseException;
	 
	 /**
	  * 
	  * @param department
	  */
	  
	 public void saveDepartment(Department department) throws DatabaseException;
	 
	 /**
	  * 
	  * @param deptId
	  */
	  
	 public void deleteDepartment(Long deptId) throws DatabaseException;
	 
	 /**
	  * 
	  * @param department
	  */
	  
	 public void updateDepartment(Department department) throws DatabaseException;

}
