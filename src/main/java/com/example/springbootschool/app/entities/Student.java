package com.example.springbootschool.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "courses")
@ToString(exclude = "courses")
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "students")
    private final Set<Course> courses = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }
}
