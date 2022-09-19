package com.example.schoolstorage.service;

import com.example.schoolstorage.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findALl();
    void save(Student student);
    Student findById(int id);
    void delete(int id);
    Long studentCount();
    List<Student> getStudentsByCourse(String courseName);
    List<Student> getStudentsByGroup(int group);
    List<Student> getStudentsByAgeAndCourse(String courseName, int age);
    List<Student> getStudentsByGroupAndCourse(int group, String courseName);

    Optional<Student> getStudentsById(int id);
}
