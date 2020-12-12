package com.ngin.services;

import java.util.List;

import com.ngin.entities.Employee;

public interface EmployeeService {

	// Develop code to save objects
	public void insertEmployee(Employee e);
	
	// just save in memory
	public List<Employee> getAllEmployees();
	
	// Develop code to retrieve an object by primary key
	public Employee getEmployeeById(int id);
	
	// Develop code to delete/replace an object by primary key
	public void swapEmployee(int idToSwap);
	
	// displays in console
	public void showAllEmployees();
	
	// find an Employee that works for a given company
	public void showEmployeeByCompany(String com);
	
	// correct an Employee's Name	
	public void correctEmployeeName(int id, String newName);
	
}
