package com.freedom.financial.network.springbootrestapi.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="DEPARTMENT")
public class Department {
	
	@Id
	 @Column(name="DEPT_ID")
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	  
	 @Column(name="NAME")
	 @ApiModelProperty(notes = "Name of the Department")
	 private String name;
	 
	 @JsonIgnore
	 @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
     private List<Employee> employee;
	 
	 public Department() {
		}
	 
	 public Department(String name, Employee... employee) {
	        this.name = name;
	        this.employee = Arrays.asList(employee);
	        this.employee.forEach(x -> x.setDepartments(this));
	    }

 

}
