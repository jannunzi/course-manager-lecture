package com.jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Student;
import com.jga.repositories.StudentRepository;

@RestController
public class StudentService {
	@Autowired
	StudentRepository repository;
	@GetMapping("/api/student")
	public List<Student> findAllStudents() 
	{
		return (List<Student>) repository.findAll();
	}
}
