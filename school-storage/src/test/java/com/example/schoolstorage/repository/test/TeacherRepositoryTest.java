package com.example.schoolstorage.repository.test;

import com.example.schoolstorage.entity.Course;
import com.example.schoolstorage.entity.Student;
import com.example.schoolstorage.entity.Teacher;
import com.example.schoolstorage.entity.Type;
import com.example.schoolstorage.repository.CourseRepository;
import com.example.schoolstorage.repository.StudentRepository;
import com.example.schoolstorage.repository.TeacherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    private Teacher teacher;
    private Course course;
    private Student student;
    private Set<Student> students;
    private Teacher updatedTeacher;

    @Before
    public void setup() {
        students = new HashSet<Student>();
        student = new Student("Peter", 17, 2, new HashSet<Course>(), new HashSet<Teacher>());
        students.add(student);
        course = new Course("Biology", Type.Main, new Teacher(), new HashSet<Student>());
        teacher = new Teacher("Mary", 36, course, students);
        updatedTeacher = new Teacher("Mary", 37, course, students);
    }

    @Test
    public void saveTeacherAndFundById() {
        courseRepository.save(course);
        studentRepository.save(student);
        Teacher savedTeacher = teacherRepository.save(teacher);
        Optional<Teacher> foundTeacher = teacherRepository.findById(savedTeacher.getId());

        assertThat(savedTeacher).isNotNull();
        assertThat(foundTeacher).isNotNull();
        assertThat(foundTeacher.get()).isEqualTo(teacher);
    }

    @Test
    public void updateTeacherAndFundById() {
        courseRepository.save(course);
        studentRepository.save(student);
        teacherRepository.save(teacher);
        Teacher newTeacher = teacherRepository.save(updatedTeacher);
        Optional<Teacher> foundTeacher = teacherRepository.findById(newTeacher.getId());

        assertThat(newTeacher).isNotNull();
        assertThat(foundTeacher).isNotNull();
        assertThat(foundTeacher.get()).isEqualTo(updatedTeacher);
    }

    @Test
    public void deleteTeacher() {
        courseRepository.save(course);
        studentRepository.save(student);
        Teacher savedTeacher = teacherRepository.save(teacher);
        assertThat(savedTeacher).isNotNull();

        teacherRepository.delete(teacher);
        Optional<Teacher> foundTeacher = teacherRepository.findById(savedTeacher.getId());
        assertThat(foundTeacher).isEmpty();
    }

    //TODO Write tests for all methods
}
