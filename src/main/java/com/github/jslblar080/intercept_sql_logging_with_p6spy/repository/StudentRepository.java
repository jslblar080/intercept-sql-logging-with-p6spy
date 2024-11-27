package com.github.jslblar080.intercept_sql_logging_with_p6spy.repository;

import com.github.jslblar080.intercept_sql_logging_with_p6spy.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByFirstName(String firstName);
}
