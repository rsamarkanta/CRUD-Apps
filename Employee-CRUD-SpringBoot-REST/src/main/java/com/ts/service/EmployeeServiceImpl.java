package com.ts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.entity.Employee;
import com.ts.exceptions.ResourceNotFoundException;
import com.ts.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Long createEmployee(Employee employee) {
		empRepo.save(employee);
		return employee.getId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee getById(long empId) {
		return empRepo.findById(empId).orElseThrow(
				() -> new ResourceNotFoundException("Employee information is not available with this Id."));
	}

	@Override
	public Long deleteById(long empId) {
		empRepo.findById(empId).orElseThrow(
				() -> new ResourceNotFoundException("Employee information is not available with this Id."));
		empRepo.deleteById(empId);
		return empId;
	}

	@Override
	public Long updateEmployeeById(long id, Employee emp) {
		Employee employee = empRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee information is not available with this Id."));
		employee.setName(emp.getName());
		employee.setSalary(emp.getSalary());
		employee.setAge(emp.getAge());
		employee.setAddress(emp.getAddress());
		empRepo.save(employee);
		return employee.getId();
	}

}
