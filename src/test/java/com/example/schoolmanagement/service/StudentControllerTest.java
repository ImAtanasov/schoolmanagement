package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class StudentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    public StudentControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testCountAllStudents() throws Exception {
        when(studentService.countAllStudents()).thenReturn(30L);

        mockMvc.perform(get("/students/count"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(30)));
    }

    @Test
    public void testGetStudentsOlderThanAndByCourse() throws Exception {
        Student student1 = new Student();
        student1.setName("V V");
        student1.setAge(21);

        Student student2 = new Student();
        student2.setName("X X");
        student2.setAge(22);

        List<Student> students = Arrays.asList(student1, student2);

        when(studentService.getStudentsOlderThanAndByCourse(20, "Course1")).thenReturn(students);

        mockMvc.perform(get("/students/age/20/course/Course1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("V V")))
                .andExpect(jsonPath("$[1].name", is("X X")));
    }

}
