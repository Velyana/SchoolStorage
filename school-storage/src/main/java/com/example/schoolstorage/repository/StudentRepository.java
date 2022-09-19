package com.example.schoolstorage.repository;

import com.example.schoolstorage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

   // @Query(value = "SELECT s from Student s, Course c WHERE c.name = ?1")
    @Query(value = "SELECT s from Student s INNER JOIN s.courses c WHERE c.name IN (?1)")
    List<Student> getStudentsByCourse(String courseName);

    @Query(value = "SELECT s from Student s WHERE s.group = ?1")
    List<Student> getStudentsByGroup(int group);

    @Query(value = "SELECT s from Student s, Course c WHERE s.group = ?1 AND c.name = ?2")
    List<Student> getStudentsByGroupAndCourse(int group, String name);

    @Query(value = "SELECT s from Student s, Course c WHERE c.name = ?1 AND s.age > ?2 ")
    List<Student> getStudentsByAgeAndCourse(String name, int age);

    List<Student> getStudentByGroup(int group);

    Optional<Student> getStudentsById(int id);

}
