package com.dhiraj.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhiraj.demo.dto.StudentDto;
import com.dhiraj.demo.entity.Course;
import com.dhiraj.demo.entity.Student;
import com.dhiraj.demo.repo.CourseRepo;
import com.dhiraj.demo.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private StudentRepo studentRepo;


	public Student saveStudent(StudentDto studentDto)
	{
		Student student = new Student();

		student.setname(studentDto.getName());
		List<Course> coursesList = courseRepo.findByNameIn(studentDto.getCourses());

		Set<Course> courseSet = new HashSet<>();

		coursesList.forEach(i -> courseSet.add(i));

		student.setCourses(courseSet);
		// student.getCourses().addAll(courseSet);
		return studentRepo.save(student);
		
	}

	public Student updateStudent(StudentDto studentDto, Long id) {
		Student student = studentRepo.findById(id).get();
		student.getCourses().addAll(courseRepo.findByNameIn(studentDto.getCourses()));
		return studentRepo.save(student);

	}

	public Iterable<Student> getAll() {
		return studentRepo.findAll();
	}

	public Student getById(Long id) {
		return studentRepo.findById(id).orElseThrow();
	}

	public void delById(Long id) {
		studentRepo.deleteById(id);
	}

	public void delAllStudent() {
		studentRepo.deleteAll();
	}

}
