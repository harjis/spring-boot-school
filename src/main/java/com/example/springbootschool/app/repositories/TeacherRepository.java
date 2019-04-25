package com.example.springbootschool.app.repositories;

import com.example.springbootschool.app.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
