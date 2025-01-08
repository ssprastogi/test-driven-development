package com.rastogi.tdd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rastogi.tdd.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentControllerTest {

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        StudentController controller = new StudentController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllStudents() throws Exception {
        List<Student> students = List.of(new Student(Long.getLong("1"), "first",
                        "last", "first@gmail.com"),
                new Student(Long.getLong("2"), "second",
                        "last", "second@gmail.com"));

        String response = mockMvc.perform(MockMvcRequestBuilders.get("/students")).
                andReturn().getResponse().getContentAsString();

        assertEquals(new ObjectMapper().writeValueAsString(students), response);

    }
}