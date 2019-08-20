package com.freedom.financial.network.springbootrestapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freedom.financial.network.springbootrestapi.exceptions.BaseException;
import com.freedom.financial.network.springbootrestapi.model.Department;
import com.freedom.financial.network.springbootrestapi.model.Employee;
import com.freedom.financial.network.springbootrestapi.service.DepartmentService;
import com.freedom.financial.network.springbootrestapi.service.EmployeeService;
import com.freedom.financial.network.springbootrestapi.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/springboot/rest")
@Api(value = Constants.MANAGING_EMPLOYEE_INFO, description = Constants.MANAGING_EMPLOYEE_FOR_REST_API)
public class Controller {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;
	 

	/**
	 * 
	 * @param department
	 * 
	 */

	@ApiOperation(value = Constants.SWAGGER_DEPARTMENT_PERSIST)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constants.SWAGGER_PERSIST_INFO) })
	@PostMapping("/api/persistDepartment")
	public void saveDepartment(Department department) {
		logger.info("--------Inside saveDepartment Method--------");
		logger.info("This method is used to persit the Department information in the database");
		try {
			departmentService.saveDepartment(department);
		} catch (BaseException e) {
			logger.error(e.getErrorCode(), "Failed Persist the data in system");
		}
		logger.info("-----SaveDepartment Method ends-----");
		logger.info("-----Department Data successfully persist into database-----");
	}
	
	

	/**
	 * 
	 * @return
	 */

	
	
	@ApiOperation(value = Constants.RETURN_EMPLOYEE_INFO)
	@ApiResponses(value = { @ApiResponse(code = 100, message = Constants.MESSAGE),
			@ApiResponse(code = 200, message = Constants.SUCCESSFULL_INFO) })
	@GetMapping("/api/getAllEmployees")
	public List<Employee> getEmployees() {
		logger.info("--------Inside getEmployees Method--------");
		logger.info("This method is used to fetch all employee information");
		List<Employee> employees = null;
		try {
			employees = employeeService.retrieveEmployees();
			employees.forEach(emp -> {
				if (emp != null && emp.getName() != null) {
					logger.info("Employee Name " + emp.getName());
				}
				if (emp != null && emp.getEmail() != null) {
					logger.info("Employee Email " + emp.getEmail());
				}
				 
			});
		} catch (BaseException e) {
			logger.error(e.getErrorCode(), "Get Operation failed to fetch allEmployees details");
		}
		logger.info("--------Method ends----------");
		return employees;
	}
	
	

	/**
	 * 
	 * @param employeeId
	 * @return
	 */

	
	
	@ApiOperation(value = Constants.SWAGGER_EMPLOYEE_BY_ID_INFO)
	@ApiResponses(value = { @ApiResponse(code = 200, message = Constants.SUCCESSFULL_INFO) })
	@GetMapping("/api/getEmployeeById/{employeeId}")
	public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		logger.info("--------Inside getEmployee Method--------");
		logger.info("This method is used to return particular employee information");
		try {
			Employee employee = employeeService.getEmployee(employeeId);
			logger.info("Employee Name " + employee.getName());
			logger.info("Employee Email " + employee.getEmail());
		} catch (BaseException e) {
			logger.error(e.getErrorCode(), "Get Operation failed for employee by id");
		}

		return employeeService.getEmployee(employeeId);
	}
	
	

	/**
	 * 
	 * @param employee
	 */
	
	

	@ApiOperation(value = Constants.SWAGGER_EMPLOYEE_PERSIST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = Constants.SWAGGER_PERSIST_INFO) })
	@PostMapping("/api/persistEmployees")
	public void saveEmployee(Employee employee) {
		logger.info("--------Inside saveEmployee Method--------");
		logger.info("This method is used to persit the employee information in the database");
		try {
			employeeService.saveEmployee(employee);
		} catch (BaseException e) {
			logger.error(e.getErrorCode(), "Failed Persist the data in system");
		}
		logger.info("-----SaveEmployee Method ends-----");
		logger.info("-----Data successfully persist into database-----");
	}
	
	

	/**
	 * 
	 * @param employeeId
	 */
	
	

	@ApiOperation(value = Constants.SWAGGER_DELETE_EMP_BY_ID_INFO)
	@DeleteMapping("/api/deleteEmployeesById/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		logger.info("--------Inside deleteEmployee Method--------");
		logger.info("This method is used to delete the particular record from the database");
		try {
			employeeService.deleteEmployee(employeeId);
		} catch (BaseException e) {
			logger.error(e.getErrorCode(), "Failed to delete the data from the system");
		}
		logger.info("----End deleteEmployee Method-----");
		logger.info("Data deleted successfully for employeeId----->" + employeeId);
	}
	
	

	/**
	 * 
	 * @param employee
	 * @param employeeId
	 */
	
	

	@ApiOperation(value = Constants.SWAGGER_UPDATE_EMP_INFO)
	@PutMapping("/api/updateEmployeesById/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		logger.info("--------Inside updateEmployee Method--------");
		logger.info("This method is used to perform update operation in the database");
		try {
			Employee emp = employeeService.getEmployee(employeeId);
			if (emp != null) {
				employeeService.updateEmployee(employee);
			}
		} catch (BaseException e) {
			logger.error(e.getErrorCode(), "Put operation failed");
		}
		logger.info("--------End updateEmployee Method--------");
		logger.info("--------Employee data updated for this employeeId-------->" + employeeId);
	}
	
	

	/**
	 * 
	 * @param employee
	 * @param employeeId
	 */
	
	

	@ApiOperation(value = Constants.SWAGGER_UPDATE_EMP_INFO)
	@PatchMapping("/api/updateEmployeesById/{employeeId}")
	public void patchEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		logger.info("--------Inside patchEmployee Method--------");
		logger.info("This method is used to perform update operation in the database");
		try {
		Employee emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.patchEmployee(employee);
		}
		} catch (BaseException e) {
			logger.error(e.getErrorCode(), "PATCH operation failed");
		}
		logger.info("--------End patchEmployee Method--------");
		logger.info("--------Employee data patched for this employeeId-------->" + employeeId);
	}

}
