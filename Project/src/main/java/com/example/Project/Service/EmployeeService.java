package com.example.Project.Service;

import com.example.Project.Entity.EmployeeEntity;
import com.example.Project.Repository.EmployeeRepo;

import duplicateException.EmployeeDuplicateException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        // You can add any validation logic here before saving the employee
    	
    	 if (employeeRepository.findByEmpNo(employee.getEmpNo()).isPresent()) {
             throw new EmployeeDuplicateException("Employee with this empNo already exists.");
         }

         if (employeeRepository.findByEmpName(employee.getEmpName()).isPresent()) {
             throw new EmployeeDuplicateException("Employee with this empName already exists.");
         }

         // If not duplicated, save the employee
         return employeeRepository.save(employee);
    
        
    
    }
    
    
    
    public boolean isDuplicateEmployee(EmployeeEntity employee) {
        // Check if empNo or empName already exists
        Optional<EmployeeEntity> existingEmpNo = employeeRepository.findByEmpNo(employee.getEmpNo());
        Optional<EmployeeEntity> existingEmpName = employeeRepository.findByEmpName(employee.getEmpName());

        return existingEmpNo.isPresent() || existingEmpName.isPresent();
    }

    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        if (isDuplicateEmployee(employee)) {
            throw new EmployeeDuplicateException("Employee with this empNo or empName already exists.");
        }

        // If not duplicated, save the employee
        return employeeRepository.save(employee);
    }

    
    
    
    
    
    
    
    
    
    public Optional<EmployeeEntity> getEmployeeByEmpNo(String empNo) {
        return employeeRepository.findByEmpNo(empNo);
    }

}
