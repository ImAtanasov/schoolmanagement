package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.service.StudentService;
import com.example.schoolmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/groups/{groupName}/courses/{courseName}/members")
    public List<Object> getMembersByGroupAndCourse(@PathVariable String groupName, @PathVariable String courseName) {
        List<Student> allStudents = studentService.findStudentsByGroupAndCourse(groupName, courseName);
        List<Teacher> allTeachers = teacherService.findTeachersByGroupAndCourse(groupName, courseName);

        List<Object> members = new ArrayList<>();
        members.addAll(allStudents);
        members.addAll(allTeachers);

        return members;
    }
}
