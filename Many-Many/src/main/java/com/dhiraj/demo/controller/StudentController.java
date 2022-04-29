package com.dhiraj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.demo.dto.StudentDto;
import com.dhiraj.demo.entity.Student;
import com.dhiraj.demo.service.StudentService;

@RestController


public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/students")
	public Student createStudent(@RequestBody StudentDto studentDto) {
		System.out.println(studentDto.getCourses());
		return studentService.saveStudent(studentDto);
	}

	@PutMapping("/students/{id}")
	public Student updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id) {
		return studentService.updateStudent(studentDto, id);
	}

	@GetMapping("/students")
	public Iterable<Student> getStudent() {
		return studentService.getAll();
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable Long id) {
		return studentService.getById(id);
	}

	@DeleteMapping("/students/{id}")
	public void delStudent(@PathVariable Long id) {
		studentService.delById(id);
	}

	@DeleteMapping("/students")
	public void delAllStudent() {
		studentService.delAllStudent();
	}

}
