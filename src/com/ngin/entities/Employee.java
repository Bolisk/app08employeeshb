package com.ngin.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // is essential only for session class
	private int id;

	private String company;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	// java bean
	public Employee() {
	}
	
	

	public Employee(String company, String firstName, String lastName) {
		super();
		this.company = company;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}