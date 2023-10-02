package com.ts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ts.entity.Employee;

@Service
public interface IEmployeeService {

//create,read,update,delete,
	public Long createEmployee(Employee emp);

	public List<Employee> getAllEmployee();

	public Employee getById(long empId);

	public Long deleteById(long empId);

	public Long updateEmployeeById(long empId, Employee emp);

}
