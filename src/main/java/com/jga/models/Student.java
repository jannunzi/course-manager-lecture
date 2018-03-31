package com.jga.models;

import javax.persistence.Entity;

import com.jga.models.User;

@Entity
public class Student extends User {
	private float gpa;
	private int graduationYear;
	public Student() {
		super();
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public int getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}
}
