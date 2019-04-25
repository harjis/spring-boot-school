package com.example.springbootschool.db;

import com.example.springbootschool.app.entities.Course;
import com.example.springbootschool.app.entities.Teacher;
import com.example.springbootschool.app.repositories.CourseRepository;
import com.example.springbootschool.app.repositories.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@Slf4j
public class Seeds {

    @Bean
    CommandLineRunner initDataBase(
            CourseRepository courseRepository,
            TeacherRepository teacherRepository
    ) {
        return args -> {
            this.initCources(courseRepository, teacherRepository);
        };
    }

    void initCources(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        Teacher teacher = new Teacher("Teacher 1");
        Teacher teacher2 = new Teacher("Teacher 2");
        teacherRepository.save(teacher);
        teacherRepository.save(teacher2);

        Course course = new Course("Course 1");
        Course course2 = new Course("Course 2");
        course.addTeachers(new HashSet<>(Arrays.asList(teacher, teacher2)));
        course2.addTeachers(new HashSet<>(Arrays.asList(teacher2)));
        courseRepository.save(course);
        courseRepository.save(course2);
    }
}
