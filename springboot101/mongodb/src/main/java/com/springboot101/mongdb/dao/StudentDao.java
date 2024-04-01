package com.springboot101.mongdb.dao;

import com.springboot101.mongdb.pojo.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentDao {
    void save(Student student);

    void update(Student student);

    List<Student> findAll();

    void delete(Integer id);
}
