package com.TechSamar.dao;

import com.TechSamar.Employee.Employee;

public interface EmployeeDAO {

	// create employee
	public void createEmployee(Employee emp);

	// show all employee
	public void showAllEmployee();

	// show employee by id
	public void showEmployeeById(int id);

	// update employee
	public void updateEmployee(int id, String name);

	// delete employee
	public void deleteEmployee(int id);

}
