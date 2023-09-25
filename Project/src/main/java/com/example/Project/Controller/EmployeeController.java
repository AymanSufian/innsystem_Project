package com.example.Project.Controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Project.Entity.EmployeeEntity;
import com.example.Project.Repository.EmployeeRepo;
import com.example.Project.Service.EmployeeService;

import duplicateException.EmployeeDuplicateException;
	
	@RestController
	@RequestMapping("/api/employees")
	public class EmployeeController {
	    
		@Autowired
	    private EmployeeService employeeService;
		
		@Autowired
		private EmployeeRepo employeeRepository;
		
		

		@PostMapping("/create")
	    public ResponseEntity<EmployeeEntity> createEmployee(@ModelAttribute EmployeeEntity employee) {

			try {	
	        	
	            EmployeeEntity savedEmployee = employeeService.saveEmployee(employee);
	            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	        } 
	        
	        
	        catch (EmployeeDuplicateException e) {
	        	
	        	System.out.println("empNo or empName are already exists !");
	        	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        
	        
	        
	    }
	    
		
	    
	    @GetMapping("/get/{empNo}")
	    public ResponseEntity<EmployeeEntity> getEmployeeByEmpNo(@PathVariable String empNo) {
	        try {
	            Optional<EmployeeEntity> employee = employeeRepository.findByEmpNo(empNo);
	            return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }


	    
	}