package com.example.schoolmanagement.service;

import com.example.schoolmanagement.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void testAddTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("Ccc Ccc");
        teacher.setAge(30);
        Teacher savedTeacher = teacherService.addTeacher(teacher);
        assertNotNull(savedTeacher.getId());
    }

}
