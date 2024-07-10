package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/count")
    public long countAllTeachers() {
        return teacherService.countAllTeachers();
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }

    @GetMapping("/group/{groupName}")
    public List<Teacher> getTeachersByGroup(@PathVariable String groupName) {
        return teacherService.getTeachersByGroup(groupName);
    }

    @GetMapping("/{groupName}/{courseName}")
    public List<Teacher> getTeachersByGroupAndCourse(@PathVariable String groupName, @PathVariable String courseName) {
        return teacherService.findTeachersByGroupAndCourse(groupName, courseName);
    }

}
