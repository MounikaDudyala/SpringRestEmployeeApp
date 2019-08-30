package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springrest.modal.Employee;
import com.springrest.service.EmployeeService;

@RestController
@RequestMapping(value = "/")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> fetchEmployees() {
		List<Employee> employeeList = employeeService.fetchEmployees();
		if (employeeList.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> fetchEmployee(@PathVariable("id") int id) {
		Employee employee = employeeService.fetchEmployee(id);
		if (employee == null) {
			System.out.println("no employee with id:" + id);
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
		if (employeeService.isEmployeeExist(employee)) {
			System.out.println("A Employee with name " + employee.getFirstName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		employeeService.createEmployee(employee);
		HttpHeaders headers = new HttpHeaders();		
		headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getEmployeeId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		Employee currentEmployee = employeeService.fetchEmployee(id);
		if (currentEmployee == null) {
			System.out.println("Employee with id " + id + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		currentEmployee.setFirstName(employee.getFirstName());
		currentEmployee.setLastName(employee.getLastName());
		currentEmployee.setManagerId(employee.getManagerId());
		employeeService.updateEmployee(currentEmployee);
		return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {

		Employee employee = employeeService.fetchEmployee(id);
		if (employee == null) {
			System.out.println("Employee with id " + id + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
}
