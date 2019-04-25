package com.example.springbootschool.app.repositories;

import com.example.springbootschool.app.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
