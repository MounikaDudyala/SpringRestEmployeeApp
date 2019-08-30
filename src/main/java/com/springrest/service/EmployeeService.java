package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.EmployeeDao;
import com.springrest.modal.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public List<Employee> fetchEmployees() {
		List<Employee> employeeList = employeeDao.fetchEmployees();
		return employeeList;
	}

	public void createEmployee(Employee emp) {
		employeeDao.createEmployee(emp);

	}

	public Employee fetchEmployee(int empId) {
		Employee emp = employeeDao.fetchEmployee(empId);
		return emp;
	}

	public void updateEmployee(Employee emp) {
		employeeDao.updateEmployee(emp);
	}

	public void deleteEmployee(int empId) {
		 employeeDao.deleteEmployee(empId);
	}

	public boolean isEmployeeExist(Employee employee) {
		return fetchEmployee(employee.getEmployeeId()) != null;
	}
}
