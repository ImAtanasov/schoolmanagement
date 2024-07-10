package com.example.schoolmanagement.service;

import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    public StudentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        Student student1 = new Student();
        student1.setName("Xxx Xxx");

        Student student2 = new Student();
        student2.setName("Zzz Zzz");

        List<Student> students = Arrays.asList(student1, student2);

        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();
        assertEquals(2, result.size());
        assertEquals("Xxx Xxx", result.get(0).getName());
        assertEquals("Zzz Zzz", result.get(1).getName());
    }
}
