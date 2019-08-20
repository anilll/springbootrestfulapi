package com.freedom.financial.network.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freedom.financial.network.springbootrestapi.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
