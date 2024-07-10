package com.example.schoolmanagement.service;

import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public long countAllTeachers() {
        return teacherRepository.countAllStudents();
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getTeachersByGroup(String groupName) {
        return teacherRepository.findByGroup_Name(groupName);
    }

    public List<Teacher> findTeachersByGroupAndCourse(String groupName, String courseName) {
        return teacherRepository.findTeachersByGroupAndCourse(groupName, courseName);
    }
}
