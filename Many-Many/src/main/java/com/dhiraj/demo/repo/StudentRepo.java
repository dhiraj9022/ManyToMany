package com.dhiraj.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.demo.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

}
