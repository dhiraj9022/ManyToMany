package com.dhiraj.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentDto {

	private String name;
	List<String> courses = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

}
