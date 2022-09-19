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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    private Student student;
    private Course course;
    private Set<Course> courses;
    private Set<Teacher> teachers;

    @Before
    public void setup() {
        courses = new HashSet<>();
        teachers = new HashSet<>();
        courses.add(new Course("Biology", Type.Main, new Teacher(), new HashSet<Student>()));
        teachers.add(new Teacher("Peter", 17,  new Course(), new HashSet<Student>()));

        student = new Student("Grigor", 18, 2, courses, teachers);
    }

    @Test
    public void saveStudentAndFundById() {
        Student savedStudent = studentRepository.save(student);
        Optional<Student> foundStudent = studentRepository.findById(savedStudent.getId());

        assertThat(savedStudent).isNotNull();
        assertThat(foundStudent).isNotNull();
        assertThat(foundStudent.get()).isEqualTo(student);
    }

    //TODO Write tests for all methods

}
