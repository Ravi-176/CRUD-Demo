package com.CRUD.crudDemo.dao;

import com.CRUD.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {
     void save(Student student);
     Student findById(int id);
     List<Student> findAll();
     List<Student> findByLastName(String last);
     void update(Student theStudent);
     void delete(int id);
     int deleteAll();
}
