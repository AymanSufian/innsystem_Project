package com.example.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Project.Entity.EmployeeEntity;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
	
	    Optional<EmployeeEntity> findByEmpNo(String empNo);
	    Optional<EmployeeEntity> findByEmpName(String empName);

}
