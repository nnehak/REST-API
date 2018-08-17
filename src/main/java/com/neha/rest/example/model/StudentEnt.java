//package com.neha.rest.example.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//
//@Entity
//public class StudentEnt {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "student_Sequence")
//	@SequenceGenerator(name = "student_sequence", sequenceName="STUDENT_SEQUENCE")
//	private Long id;
//	
//	@Column(name="firstName")
//	private String firstName;
//	@Column(name="lastName")
//	private String lastName;
//	@Column(name="year")
//	private String year;
//	
//	public StudentEnt(){
//		
//	}
//	
//	public StudentEnt(String firstName, String lastName, String year){
//		this.firstName = firstName;
//		this.lastName=lastName;
//		this.year=year;
//	}
//	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getYear() {
//		return year;
//	}
//
//	public void setYear(String year) {
//		this.year = year;
//	}
//
//
//}
