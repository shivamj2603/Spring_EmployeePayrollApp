package com.capgemini.employeepayrollapp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;

@Entity
@Table(name = "employee_payroll")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public long salary;
	public Employee(){
		
	}
	public Employee(EmployeePayrollDTO employeeDTO) {
		this.name = employeeDTO.name;
		this.salary = employeeDTO.salary;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
