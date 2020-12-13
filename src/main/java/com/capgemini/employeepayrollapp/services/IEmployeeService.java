package com.capgemini.employeepayrollapp.services;
import java.util.List;
import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.exceptions.EmployeeException;
import com.capgemini.employeepayrollapp.model.Employee;

public interface IEmployeeService {
	List<Employee> getEmployees();
	Employee addEmployee(EmployeePayrollDTO employeeDTO) throws EmployeeException;
	Employee getEmployeeById(int empId) throws EmployeeException;
	Employee updateEmployeeById(int id, EmployeePayrollDTO employeeDTO) throws EmployeeException;
	void deleteEmployeeById(int id) throws EmployeeException;
}
