package com.capgemini.employeepayrollapp.model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table(name = "employee_payroll")
public @Data class Employee {
	@Id
	private int id;
	private String name;
	private double salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> department;
	public Employee(){
	}
	public Employee(int id, EmployeePayrollDTO employeeDTO) {
		this.id = id;
		this.name = employeeDTO.getName();
		this.salary = employeeDTO.getSalary();
		this.gender = employeeDTO.getGender();
		this.startDate = employeeDTO.getStartDate();
		this.note = employeeDTO.getNote();
		this.department = employeeDTO.getDepartment();
	}
}
