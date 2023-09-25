package com.example.Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emp_project")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeEntity {	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
    	private int id;
	
		@Column(name = "emp_no")
	    private String empNo;
	    
		@Column(name = "emp_name")
	    private String empName;
	    
		@Column(name = "gender")
	    private String gender;
	    
		@Column(name = "email")
	    private String email;
	    
		@Column(name = "dob")
	    private String dob;
	    
		@Column(name = "nationality")
	    private String nationality;


}
