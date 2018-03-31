package com.jga.repositories;
import org.springframework.data.repository.*;
import com.jga.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> { }
