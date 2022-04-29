package com.dhiraj.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.demo.entity.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {

	Course findByName(String name);

	List<Course> findByNameIn(List<String> courses);
}
