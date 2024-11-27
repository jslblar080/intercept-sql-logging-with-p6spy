package com.github.jslblar080.intercept_sql_logging_with_p6spy.controller;

import com.github.jslblar080.intercept_sql_logging_with_p6spy.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.jslblar080.intercept_sql_logging_with_p6spy.service.StudentService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    private final StringBuilder sb = new StringBuilder();

    public StudentController(@Autowired StudentService studentService) {
        this.studentService = studentService;
    }

    // Talend API Tester
    /*
    http://localhost:8080/student/post

    {
      "firstName" : "Jungsoo",
      "lastName" : "Lee"
    }

    {
      "firstName" : "Jason",
      "lastName" : "Lee"
    }

    {
      "firstName" : "Jungsoo",
      "lastName" : "Kim"
    }

    {
      "firstName" : "Jungsoo",
      "lastName" : "Lee"
    }
     */
    @PostMapping(path = "/post")
    public void save(@RequestBody Student student) throws RuntimeException {

        Long studentId = studentService.save(student);

        Optional<Student> studentRegistered = studentService.findById(studentId);
        if (studentRegistered.isPresent()) {
            log.info(studentRegistered.get().toString());
        } else
            throw new RuntimeException("Student not registered!");
    }

    // http://localhost:8080/student/Jungsoo
    /*
    Student(id=1, firstName=Jungsoo, lastName=Lee)
    Student(id=3, firstName=Jungsoo, lastName=Kim)
    Student(id=4, firstName=Jungsoo, lastName=Lee)
     */
    @GetMapping(path = "/{firstName}")
    public String getAll(@PathVariable(name = "firstName") String fN) {

        List<Student> studentList = studentService.findAllByFirstName(fN);
        sb.setLength(0);

        sb.append("<html><body>");
        for (Student student : studentList) {
            sb.append("<h1>").append(student.toString()).append("</h1>");
        }
        sb.append("<body><html>");

        return sb.toString();
    }
}
