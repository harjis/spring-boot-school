package com.example.springbootschool.app.services;

import com.example.springbootschool.app.entities.Course;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CourseService {
    private final EntityManager entityManager;

    public CourseService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Course> findAll() {
        return entityManager.createQuery(
                "select c " +
                        "from Course c ", Course.class
        ).getResultList();
    }

    public List<Course> findAllEager(){
        return entityManager.createQuery(
                "select c " +
                        "from Course c " +
                        "join fetch c.teachers t", Course.class
        ).getResultList();
    }
}
