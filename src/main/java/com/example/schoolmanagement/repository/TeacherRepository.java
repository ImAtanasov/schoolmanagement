package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByGroup_Name(String groupName);
    @Query("SELECT t FROM Teacher t JOIN t.courses c WHERE t.group.name = :groupName AND c.name = :courseName")
    List<Teacher> findTeachersByGroupAndCourse(@Param("groupName") String groupName, @Param("courseName") String courseName);
    @Query("SELECT COUNT(t) FROM Teacher t")
    long countAllStudents();
}
