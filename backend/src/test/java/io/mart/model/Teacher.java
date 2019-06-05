package io.mart.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Teacher {

	private Integer id;

	private String firstName;
	private String lastName;

	private Integer age;
	private String speciality;


	public String getFirstName() {
		return firstName;
	}


	public Teacher setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}


	public String getLastName() {
		return lastName;
	}


	public Teacher setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}


	public Integer getAge() {
		return age;
	}


	public Teacher setAge(Integer age) {
		this.age = age;
		return this;
	}


	public String getSpeciality() {
		return speciality;
	}


	public Teacher setSpeciality(String speciality) {
		this.speciality = speciality;
		return this;
	}


	public Integer getId() {
		return id;
	}


	public Teacher setId(Integer id) {
		this.id = id;
		return this;
	}
	
	
	@Override
	public String toString() {
		return "Teacher{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				", speciality='" + speciality + '\'' +
				'}';
	}
}
