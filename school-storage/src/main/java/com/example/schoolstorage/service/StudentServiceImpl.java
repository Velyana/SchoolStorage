package com.example.schoolstorage.service;

import com.example.schoolstorage.entity.Student;
import com.example.schoolstorage.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findALl() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Long studentCount() {
        return studentRepository.count();
    }

    @Override
    public List<Student> getStudentsByCourse(String courseName) {
        return studentRepository.getStudentsByCourse(courseName);
    }

    @Override
    public List<Student> getStudentsByGroup(int group) {
        return studentRepository.getStudentsByGroup(group);
    }

    @Override
    public List<Student> getStudentsByAgeAndCourse(String courseName, int age) {
        return studentRepository.getStudentsByAgeAndCourse(courseName, age);
    }

    @Override
    public List<Student> getStudentsByGroupAndCourse(int group, String courseName) {
        return studentRepository.getStudentsByGroupAndCourse(group, courseName);
    }

    @Override
    public Optional<Student> getStudentsById(int id) {
        return studentRepository.getStudentsById(id);
    }


}
