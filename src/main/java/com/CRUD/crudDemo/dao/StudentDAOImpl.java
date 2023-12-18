package com.CRUD.crudDemo.dao;

import com.CRUD.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define field for entity manager
    private EntityManager entityManager;
    //Inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
//Implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        //return list of Students
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String last) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        //set the parameters
        theQuery.setParameter("theData",last);
        //return the result list
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        //Retrieve the student
        Student theStudent = entityManager.find(Student.class,5);
        //Delete the student
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int count = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return count;
    }
}
