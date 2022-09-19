package com.example.schoolstorage.service.test;

import static org.mockito.Mockito.verify;

import com.example.schoolstorage.repository.TeacherRepository;
import com.example.schoolstorage.service.TeacherService;
import com.example.schoolstorage.service.TeacherServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest {

    @Mock private TeacherRepository teacherRepository;
    private TeacherService teacherService;
    private String courseName = "Math";

    @BeforeEach void setUp() {
        this.teacherService
                = new TeacherServiceImpl(teacherRepository);
    }

    @Test void getAllPerson() {
        teacherService.getTeachersByCourse(courseName);
        verify(teacherRepository).getTeachersByCourse(courseName);
    }

    //TODO Write tests for all methods

}
