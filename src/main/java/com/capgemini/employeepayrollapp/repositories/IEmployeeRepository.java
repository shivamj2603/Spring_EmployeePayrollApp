package com.capgemini.employeepayrollapp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.employeepayrollapp.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer>{

}
