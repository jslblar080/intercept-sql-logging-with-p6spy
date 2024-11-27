package com.github.jslblar080.intercept_sql_logging_with_p6spy.service;

import com.github.jslblar080.intercept_sql_logging_with_p6spy.domain.Student;
import com.github.jslblar080.intercept_sql_logging_with_p6spy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(@Autowired StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Long save(Student student) {

        return studentRepository.save(student).getId();
    }

    @Transactional
    public Optional<Student> findById(Long id) {

        return studentRepository.findById(id);
    }

    @Transactional
    public List<Student> findAllByFirstName(String firstName) {

        return studentRepository.findAllByFirstName(firstName);
    }
}
