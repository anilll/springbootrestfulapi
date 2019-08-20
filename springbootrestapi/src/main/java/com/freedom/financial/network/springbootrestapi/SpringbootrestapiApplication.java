package com.freedom.financial.network.springbootrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.freedom.financial.network.springbootrestapi.model.Department;
import com.freedom.financial.network.springbootrestapi.model.Employee;
import com.freedom.financial.network.springbootrestapi.repository.DepartmentRepository;
import com.freedom.financial.network.springbootrestapi.repository.EmployeeRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.freedom.financial.network.springbootrestapi")
public class SpringbootrestapiApplication implements CommandLineRunner{

	   @Autowired 
	   DepartmentRepository departmentRepository;
	   
	   @Autowired
	   EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestapiApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}

	@Override
	public void run(String... args) throws Exception {
		Department dept = new Department("Information Technology", new Employee("Anil","anil@gmail.com"), new Employee("Thapa","thapa@gmail.com"));
		departmentRepository.save(dept);
		
	}

}
