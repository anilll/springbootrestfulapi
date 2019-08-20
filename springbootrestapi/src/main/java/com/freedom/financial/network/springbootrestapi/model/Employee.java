package com.freedom.financial.network.springbootrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	@ApiModelProperty(notes = "Name of the employee")
	private String name;

	@Column(name = "EMAIL")
	@ApiModelProperty(notes = "Email id of an employee")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
    private Department departments;
	
	public Employee() {
	}

	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}



	
	
	

	/*
	 * @ApiModelProperty(notes = "Department Id")
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "ID_DEPT") private Department department;
	 */
	
	
}
