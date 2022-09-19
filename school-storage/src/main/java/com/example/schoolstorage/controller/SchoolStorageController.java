package com.example.schoolstorage.controller;

import com.example.schoolstorage.entity.Student;
import com.example.schoolstorage.entity.Teacher;
import com.example.schoolstorage.entity.Type;
import com.example.schoolstorage.service.CourseService;
import com.example.schoolstorage.service.StudentService;
import com.example.schoolstorage.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class SchoolStorageController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        final List<Student> studentsList = studentService.findALl();
        return studentsList;
    }

    @GetMapping("/students/count")
    public Long studentsCount() {
        return studentService.studentCount();
    }

    @PostMapping("/students")
    public void createStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable int id) {
        Optional<Student> existingStudent = studentService.getStudentsById(id);
        if(existingStudent.isPresent()) {
            studentService.save(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.delete(id);
    }


    @GetMapping("/teachers")
    public List<Teacher> findAllTeachers() {
        final List<Teacher> teachersList = teacherService.findALl();
        return teachersList;
    }

    @GetMapping("/teachers/count")
    public Long teachersCount() {
        return teacherService.teacherCount();
    }


    @PostMapping("/teachers")
    public void createTeacher(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
    }


    @PutMapping("/teachers/{id}")
    public ResponseEntity<?> updateTeacher(@RequestBody Teacher teacher, @PathVariable int id) {
        Optional<Teacher> existingTeacher = teacherService.getTeachersById(id);
        if(existingTeacher.isPresent()) {
            teacherService.save(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable int id) {
        teacherService.delete(id);
    }



    @GetMapping("/courses/count")
    public Long coursesCount() {
        return courseService.courseCount();
    }

    @GetMapping("/courses/type/count")
    public Long coursesCount(@RequestParam Type type) {
        return courseService.countByType(type);
    }

    @GetMapping("/students/course")
    public List<Student> findStudentsByCourse(@RequestParam String courseName) {
        return studentService.getStudentsByCourse(courseName);
    }

    @GetMapping("/students/group")
    public List<Student> findStudentsByGroup(@RequestParam int group) {
        return studentService.getStudentsByGroup(group);
    }

    @GetMapping("/students/age/course")
    public List<Student> findStudentsByAgeAndCourse(@RequestParam String courseName, @RequestParam int age) {
        return studentService.getStudentsByAgeAndCourse(courseName, age);
    }
}
