package com.ts.service;

import java.util.List;

import com.ts.entity.Employee;

public interface IEmployeeMgmtService {

	public int save(Employee emp);

	public void update(Employee emp, int id);

	public int delete(int id);

	public Employee getEmpById(int id);

	public List<Employee> getEmployees();
}
