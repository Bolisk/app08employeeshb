package com.ngin.main;

import com.ngin.entities.Employee;
import com.ngin.services.EmployeeService;

public class Play {
	
	private static EmployeeService serve;

	public static void main(String[] args) {
		
		// we create some employees to proceed 
		Employee john = new Employee("nginstudios", "John", "Carter");
		Employee kathrine = new Employee("nginstudios", "Kathrine", "Smith");
		
		serve.insertEmployee(john);
		serve.insertEmployee(kathrine);
		
		//we then print the list via a method get all
		serve.showAllEmployees();
		
		// should output Employee not found
		serve.showEmployeeByCompany("mickey toys");
	}

}
