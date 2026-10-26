package com.example.studentsearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void existingStudentReturns200() throws Exception {
        mockMvc.perform(get("/api/v1/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.fullName").value("Nguyen Van An"))
                .andExpect(jsonPath("$.major").value("Information Technology"));
    }

    @Test
    void missingStudentReturns404WithExpectedJson() throws Exception {
        mockMvc.perform(get("/api/v1/students/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message").value("Sinh viên không tồn tại"))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());
    }
}
