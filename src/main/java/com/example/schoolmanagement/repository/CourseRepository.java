package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c.type, COUNT(c) FROM Course c GROUP BY c.type")
    List<Object[]> countCoursesByType();
}
