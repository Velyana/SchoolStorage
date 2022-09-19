package com.example.schoolstorage.service;

import com.example.schoolstorage.entity.Student;
import com.example.schoolstorage.entity.Teacher;
import com.example.schoolstorage.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherServiceImpl() {}

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Long teacherCount() {
        return teacherRepository.count();
    }

    @Override
    public List<Teacher> findALl() {
        return teacherRepository.findAll();
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Student> getTeachersByCourse(String courseName) {
        return teacherRepository.getTeachersByCourse(courseName);
    }

    @Override
    public Optional<Teacher> getTeachersById(int id) {
        return teacherRepository.getTeachersById(id);
    }


}
