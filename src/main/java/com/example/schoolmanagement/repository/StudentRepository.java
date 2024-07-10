package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourses_Name(String courseName);
    List<Student> findByGroup_Name(String groupName);
    List<Student> findByAgeGreaterThanAndCourses_Name(int age, String courseName);
    @Query("SELECT s FROM Student s JOIN s.courses c WHERE s.group.name = :groupName AND c.name = :courseName")
    List<Student> findStudentsByGroupAndCourse(@Param("groupName") String groupName, @Param("courseName") String courseName);
    @Query("SELECT COUNT(s) FROM Student s")
    long countAllStudents();
}
