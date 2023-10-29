package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);
    void update(Student student);

    void delete(int id);

    int deleteAll();
    List<Student> findAll();
    Student findStudentById(int id);




}
