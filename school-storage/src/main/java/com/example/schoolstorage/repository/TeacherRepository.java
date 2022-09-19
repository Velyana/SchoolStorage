package com.example.schoolstorage.repository;

import com.example.schoolstorage.entity.Student;
import com.example.schoolstorage.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query(value = "SELECT t FROM Teacher t, Course c WHERE c.name = ?2")
    List<Student> getTeachersByCourse(String name);

    Optional<Teacher> getTeachersById(int id);

}
