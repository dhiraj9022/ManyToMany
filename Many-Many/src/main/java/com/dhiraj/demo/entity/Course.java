package com.dhiraj.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "name is required")
	@NotBlank(message = "name cannot be blank")
	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@ManyToMany(mappedBy = "courses")
	@JsonBackReference
	private Set<Student> students = new HashSet<>();

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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
