package com.example.springbootschool.app.repositories;

import com.example.springbootschool.app.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
