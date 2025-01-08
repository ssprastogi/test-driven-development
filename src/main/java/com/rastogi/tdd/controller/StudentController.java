package com.rastogi.tdd.controller;

import com.rastogi.tdd.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents(){
        return List.of(new Student(Long.getLong("1"),"first",
                        "last","first@gmail.com"),
                new Student(Long.getLong("2"),"second",
                        "last","second@gmail.com"));
    }
}
