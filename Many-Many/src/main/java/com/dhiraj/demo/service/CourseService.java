package com.dhiraj.demo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhiraj.demo.dto.CourseDto;
import com.dhiraj.demo.entity.Course;
import com.dhiraj.demo.exception.AlreadyExistsException;
import com.dhiraj.demo.repo.CourseRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;

	public Course saveCourse(@Valid CourseDto courseDto) {

		if (courseRepo.findByName(courseDto.getname()) != null) {
			throw new AlreadyExistsException("course with name :" + courseDto.getname() + " already exists");
//			throw new AlreadyExistsException("course with name :" + courseDto.getname() + " already exists");
		} else {
			System.out.println("Me hete");
		}

		Course course = new Course();
		course.setname(courseDto.getname());
		return courseRepo.save(course);
	}



	public Iterable<Course> findAll() {
		return courseRepo.findAll();
	}


	public Course getbyId(Long id) {
		return courseRepo.findById(id).orElseThrow();
	}

	public void delbyId(Long id) {

		courseRepo.deleteById(id);

	}

	public void delAll() {

		courseRepo.deleteAll();

	}
}
