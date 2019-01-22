package com.muammer.netascase.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public String studentNumber;

	@Column(name = "name", nullable = false)
	public String studentName;

	@Column(name = "surname", nullable = false)
	public String studentSurname;

	@Column(name = "mobilenumber", nullable = false)
	public String phoneNumber;

	@Column(name = "city", nullable = false)
	public String city;

	@Column(name = "ilce")
	public String distinct;

	@Column(name = "image")
	public Blob image;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistinct() {
		return distinct;
	}

	public void setDistinct(String distinct) {
		this.distinct = distinct;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Student(String studentNumber, String studentName, String studentSurname, String phoneNumber) {
		super();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.phoneNumber = phoneNumber;

	}

	public Student() {
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", studentName=" + studentName + ", studentSurname="
				+ studentSurname + ", phoneNumber=" + phoneNumber + ", city=" + city + ", distinct=" + distinct
				+ ", image=" + image + "]";
	}

}
