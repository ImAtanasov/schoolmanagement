package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/count")
    public long countAllStudents() {
        return studentService.countAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @GetMapping("/course/{courseName}")
    public List<Student> getStudentsByCourse(@PathVariable String courseName) {
        return studentService.getStudentsByCourse(courseName);
    }

    @GetMapping("/group/{groupName}")
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return studentService.getStudentsByGroup(groupName);
    }

    @GetMapping("/age/{age}/course/{courseName}")
    public List<Student> getStudentsOlderThanAndByCourse(@PathVariable int age, @PathVariable String courseName) {
        return studentService.getStudentsOlderThanAndByCourse(age, courseName);
    }

    @GetMapping("/{groupName}/{courseName}")
    public List<Student> getStudentsByGroupAndCourse(@PathVariable String groupName, @PathVariable String courseName) {
        return studentService.findStudentsByGroupAndCourse(groupName, courseName);
    }
}
