package com.example.schoolmanagement.service;

import com.example.schoolmanagement.model.Course;
import com.example.schoolmanagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        course.setId(id);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Map<String, Long> countCoursesByType() {
        List<Object[]> results = courseRepository.countCoursesByType();
        Map<String, Long> counts = new HashMap<>();
        for (Object[] result : results) {
            counts.put(result[0].toString(), (Long) result[1]);
        }
        return counts;
    }
}
