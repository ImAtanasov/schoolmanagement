package com.example.schoolmanagement.service;

import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public long countAllStudents() {
        return studentRepository.countAllStudents();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    public List<Student> getStudentsByCourse(String courseName) {
        return studentRepository.findByCourses_Name(courseName);
    }

    public List<Student> getStudentsByGroup(String groupName) {
        return studentRepository.findByGroup_Name(groupName);
    }

    public List<Student> getStudentsOlderThanAndByCourse(int age, String courseName) {
        return studentRepository.findByAgeGreaterThanAndCourses_Name(age, courseName);
    }

    public List<Student> findStudentsByGroupAndCourse(String groupName, String courseName) {
        return studentRepository.findStudentsByGroupAndCourse(groupName, courseName);
    }

}
