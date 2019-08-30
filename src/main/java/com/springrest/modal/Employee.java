	package com.springrest.modal;

public class Employee {
	private int empId;
	private String firstName;
	private String lastName;
	private int managerId;

	public Employee() {

	}

	public Employee(int empId, String firstName, String lastName, int managerId) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.managerId = managerId;
	}

	public void setEmployeeId(int empId) {
		this.empId = empId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getEmployeeId() {
		return empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getManagerId() {
		return managerId;
	}

	public String toString() {
		return "Id:" + empId + " FirstName:" + firstName + " LastName:" + lastName + " ManagerId:" + managerId;
	}
}
