package com.example.schoolstorage.service;

import com.example.schoolstorage.entity.Course;
import com.example.schoolstorage.entity.Type;

import java.util.List;

public interface CourseService {

    List<Course> findALl();

    void save(Course course);

    Course findById(int id);

    void delete(int id);

    Long courseCount();

    Long countByType(Type type);
}
