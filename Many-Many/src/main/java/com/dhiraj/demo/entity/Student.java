package com.dhiraj.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToMany
	@JsonManagedReference
	@JoinTable(name = "student_course", inverseJoinColumns = @JoinColumn(name = "course_id"), joinColumns = @JoinColumn(name = "student_id"))
	private Set<Course> courses = new HashSet<>();

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


}
