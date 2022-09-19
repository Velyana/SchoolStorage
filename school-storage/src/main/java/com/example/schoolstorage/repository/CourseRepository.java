package com.example.schoolstorage.repository;

import com.example.schoolstorage.entity.Course;
import com.example.schoolstorage.entity.Student;
import com.example.schoolstorage.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Long countByType(Type type);

    List<Course> findByType(String type);



}
