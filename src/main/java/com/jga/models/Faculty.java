package com.jga.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Faculty extends User {
	private String office;
	private boolean tenured;
	@OneToMany(mappedBy="author")
	@JsonIgnore
	private List<Course> authored;
	
	public void authoredCourse(Course course) {
		this.authored.add(course);
		if(course.getAuthor() != this) {
			course.setAuthor(this);
		}
	}
	
	public List<Course> getAuthored() {
		return authored;
	}
	public void setAuthored(List<Course> authored) {
		this.authored = authored;
	}
	public Faculty() {
		super();
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public boolean isTenured() {
		return tenured;
	}
	public void setTenured(boolean tenured) {
		this.tenured = tenured;
	}
}
