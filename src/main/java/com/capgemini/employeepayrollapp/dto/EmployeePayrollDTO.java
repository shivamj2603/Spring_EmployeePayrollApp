package com.capgemini.employeepayrollapp.dto;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import lombok.Data;

public @Data class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$", message = "Employee name invalid")
	private String name;
	@Min(value = 1000, message = "Minimum wage should be atleast 500")
	private double salary;
}
