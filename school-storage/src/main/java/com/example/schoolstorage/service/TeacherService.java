package com.example.schoolstorage.service;

import com.example.schoolstorage.entity.Student;
import com.example.schoolstorage.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Long teacherCount();

    List<Teacher> findALl();

    void save(Teacher teacher);

    Teacher findById(int id);

    void delete(int id);

    List<Student> getTeachersByCourse(String courseName);

    Optional<Teacher> getTeachersById(int id);
}
