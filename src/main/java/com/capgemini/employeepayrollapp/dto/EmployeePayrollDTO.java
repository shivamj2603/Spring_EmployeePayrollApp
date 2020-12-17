package com.capgemini.employeepayrollapp.dto;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$", message = "Employee name invalid")
	private String name;
	@Min(value = 1000, message = "Minimum wage should be atleast 500")
	private double salary;
	@Pattern(regexp = "Male|Female", message = "Gender needs to be Male or Female")
	private String gender;
	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "Start date cannot be empty")
	@PastOrPresent(message = "Startdate cannot be a future date")
	private LocalDate startDate;
	@NotBlank(message = "Note cannot be blank")
	private String note;
	@NotBlank(message = "Profile Pic cannot be blank")
	private String profilePic;
	@NotNull(message = "Department should not be empty")
	private List<String> department;
}
