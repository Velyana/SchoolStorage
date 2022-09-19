package com.example.schoolstorage.service;

import com.example.schoolstorage.entity.Course;
import com.example.schoolstorage.entity.Type;
import com.example.schoolstorage.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public List<Course> findALl() {
        return courseRepository.findAll();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Long courseCount() {
        return courseRepository.count();
    }

    @Override
    public Long countByType(Type type) {
        return courseRepository.countByType(type);
    }
}
