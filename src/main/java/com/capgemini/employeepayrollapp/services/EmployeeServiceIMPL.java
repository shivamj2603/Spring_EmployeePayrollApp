package com.capgemini.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.exceptions.EmployeeException;
import com.capgemini.employeepayrollapp.model.Employee;
import com.capgemini.employeepayrollapp.repositories.IEmployeeRepository;

@Service
public class EmployeeServiceIMPL implements IEmployeeService{
	@Autowired
	IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees(){
    List<Employee> empList = new ArrayList<>();
    empList = employeeRepository.findAll();
    return empList;
   }
	@Override
	public Employee addEmployee(EmployeePayrollDTO employeeDTO) throws EmployeeException{
		int newId = 0;
		int count = (int) employeeRepository.count();
		if(count != 0)
		newId = this.getEmployees().get(count - 1).getId() ;
		Employee emp = new Employee(newId + 1, employeeDTO);
		employeeRepository.save(emp);
		return employeeRepository.findById(newId + 1)
				      .orElseThrow(() -> new EmployeeException("Employee not added"));
	}
	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee not found"));
	}
	@Override
	public Employee updateEmployeeById(int id, EmployeePayrollDTO employeeDTO) throws EmployeeException {
		Employee employee = this.getEmployeeById(id);
		employee.setName(employeeDTO.getName());
		employee.setSalary(employeeDTO.getSalary());
		employee.setGender(employeeDTO.getGender());
		employee.setNote(employeeDTO.getNote());
		employee.setStartDate(employeeDTO.getStartDate());
		employee.setDepartment(employeeDTO.getDepartment());
		employeeRepository.save(employee);
		return employeeRepository.findById(id).get();
	}
	@Override
	public void deleteEmployeeById(int id) throws EmployeeException {
		employeeRepository.findById(id)
		                   .orElseThrow(() -> new EmployeeException("Employee to be deleted not found"));
		employeeRepository.deleteById(id);
	}
}