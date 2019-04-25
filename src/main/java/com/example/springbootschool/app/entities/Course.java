package com.example.springbootschool.app.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "courses_teachers",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private final Set<Teacher> teachers = new HashSet<>();

    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "courses_students",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private final Set<Student> students = new HashSet<>();

    public Course(String name) {
        this.name = name;
    }

    public void addTeachers(Set<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            this.addTeacher(teacher);
        }
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.getCourses().add(this);
    }

    public void addStudents(Set<Student> students) {
        for (Student student : students) {
            this.addStudent(student);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        student.getCourses().add(this);
    }
}
