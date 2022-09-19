package com.example.schoolstorage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "group")
    private int group;

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") })
    @JsonIgnore
    private Set<Course> courses;

    @ManyToMany
    @JoinTable(name = "student_teacher", joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id") })
    @JsonIgnore
    private Set<Teacher> teachers;

    public Student() {}

    public Student(final String name, final int age, final int group,
                   final Set<Course> courses, final Set<Teacher> teachers) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.courses = courses;
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && group == student.group && Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(courses, student.courses) && Objects.equals(teachers, student.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, group, courses, teachers);
    }
}
