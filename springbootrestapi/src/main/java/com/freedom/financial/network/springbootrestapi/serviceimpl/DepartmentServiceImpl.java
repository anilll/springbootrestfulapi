package com.freedom.financial.network.springbootrestapi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freedom.financial.network.springbootrestapi.exceptions.DatabaseException;
import com.freedom.financial.network.springbootrestapi.model.Department;
import com.freedom.financial.network.springbootrestapi.repository.DepartmentRepository;
import com.freedom.financial.network.springbootrestapi.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	 private DepartmentRepository departmentRepository;
	 
	 public void setDepartmentRepository(DepartmentRepository departmentRepository) {
	  this.departmentRepository = departmentRepository;
	 }
	 
	 /**
	  * This method is used to retrieve the department information from the system
	  */
	 
	 public List<Department> retrieveDepartments() throws DatabaseException {
	  List<Department> departments = departmentRepository.findAll();
	  return departments;
	 }
	 
	 /**
	  * This method is used to get the particular department information from the system
	  */
	  
	 public Department getDepartment(Long deptId) throws DatabaseException {
	  Optional<Department> optDept = departmentRepository.findById(deptId);
	  return optDept.get();
	 }
	 
	 /**
	  * This method is used to persist the information in the system
	  */
	  
	 public void saveDepartment(Department department) throws DatabaseException{
	  departmentRepository.save(department);
	 }
	 
	 /**
	  * This method is used to delete the particular department from the system
	  */
	  
	 public void deleteDepartment(Long deptId) throws DatabaseException{
	  departmentRepository.deleteById(deptId);
	 }
	 
	 /**
	  * This method is used to update the particular information of department in the system
	  */
	  
	 public void updateDepartment(Department department) throws DatabaseException{
	  departmentRepository.save(department);
	 }

	 
	
}
