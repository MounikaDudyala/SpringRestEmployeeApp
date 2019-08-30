package com.springrest.dao;

import java.util.List;

import com.springrest.modal.Employee;

public interface EmployeeDao {
	void createEmployee(Employee emp);
	Employee fetchEmployee(int empId);
	List<Employee> fetchEmployees();
	void deleteEmployee(int empId);
	void updateEmployee(Employee emp);
}
