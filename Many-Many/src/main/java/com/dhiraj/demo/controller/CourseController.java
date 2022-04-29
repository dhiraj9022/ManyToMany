package com.dhiraj.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.demo.dto.CourseDto;
import com.dhiraj.demo.entity.Course;
import com.dhiraj.demo.service.CourseService;

@RestController

public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/courses")
	public ResponseEntity<Course> createCourse(@RequestBody @Valid CourseDto courseDto) {
		
//		if(courseDto.getname() == null || courseDto.getname().equals("")) {
//			return ResponseEntity.badRequest().build();
//		}
		return ResponseEntity.ok(courseService.saveCourse(courseDto));
	}


//	public Iterable<Course> getAll() {
//		return courseService.findAll();
//	}



	@GetMapping("/courses")
	public ResponseEntity<Iterable<Course>> getAll() {
		return ResponseEntity.ok(courseService.findAll());
	}

	@GetMapping("/courses/{id}")
	public Course getById(@PathVariable Long id)
	{
		return courseService.getbyId(id);
	}

	@DeleteMapping("/courses/{id}")
	public void delById(@PathVariable Long id) {
		courseService.delbyId(id);
	}

	@DeleteMapping("/courses")
	public void delAll() {
		courseService.delAll();
	}
}
