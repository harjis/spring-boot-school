package com.example.springbootschool.app.controllers;

import com.example.springbootschool.app.entities.Course;
import com.example.springbootschool.app.services.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public List<Course> index(@RequestParam(required = false) String fetchType) {
        List<Course> courses;
        if (fetchType != null && fetchType.contains("eager")) {
            courses = courseService.findAllEager();
        } else {
            courses = courseService.findAll();
        }

        for (Course course : courses) {
            System.out.println(course.getTeachers());
        }
        return courses;
    }
}
