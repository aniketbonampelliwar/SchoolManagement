package com.techdenovo.app.model;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String motherName;
	private String fatherName;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String firstName, String lastName, String motherName, String fatherName, int id) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.fatherName = fatherName;
		
	}
	public Student(String firstName, String lastName, String motherName, String fatherName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.fatherName = fatherName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", motherName="
				+ motherName + ", fatherName=" + fatherName + "]";
	}
}

