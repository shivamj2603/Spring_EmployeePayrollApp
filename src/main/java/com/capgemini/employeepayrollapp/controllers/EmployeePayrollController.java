package com.capgemini.employeepayrollapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.dto.ResponseDTO;
import com.capgemini.employeepayrollapp.exceptions.EmployeeException;
import com.capgemini.employeepayrollapp.model.Employee;
import com.capgemini.employeepayrollapp.services.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
	@Autowired
	private IEmployeeService empService;
	@GetMapping(value={"/get", "/", ""})
	public ResponseEntity<ResponseDTO> getAllEmployeeData(){
		List<Employee> empList = empService.getEmployees();
		ResponseDTO respDTO = new ResponseDTO("Details of all Employees :", empList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeeDataById(@PathVariable("empId") int empId) throws EmployeeException{
		Employee employee = empService.getEmployeeById(empId);
		ResponseDTO respDTO = new ResponseDTO("Employee Details of employee with Id : "+ empId, employee);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO) throws EmployeeException{
		Employee employee = empService.addEmployee(employeeDTO);
		ResponseDTO respDTO = new ResponseDTO("Added Employee", employee);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable("empId") int empId, @RequestBody EmployeePayrollDTO employeeDTO) throws EmployeeException{
		Employee employee = empService.updateEmployeeById(empId, employeeDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee ", employee);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeeById(@PathVariable("empId") int empId) throws EmployeeException{
		empService.deleteEmployeeById(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", empId);
		return new ResponseEntity<>(respDTO, HttpStatus.OK);
	}
}

