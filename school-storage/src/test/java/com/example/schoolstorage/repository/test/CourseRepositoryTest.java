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
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    private Course course;

    @Before
    public void setup() {
        course = new Course("Biology", Type.Main, new Teacher(), new HashSet<Student>());
    }

    @Test
    public void saveCourseAndFundById() {
        Course savedCourse = courseRepository.save(course);
        Optional<Course> foundCourse = courseRepository.findById(savedCourse.getId());

        assertThat(savedCourse).isNotNull();
        assertThat(foundCourse).isNotNull();
        assertThat(foundCourse.get()).isEqualTo(course);
    }

    //TODO Write tests for all methods
}
