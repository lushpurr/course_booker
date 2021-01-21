package com.example.coursebooking.controllers;

import com.example.coursebooking.models.Course;
import com.example.coursebooking.models.Customer;
import com.example.coursebooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCoursesAndFilters(
            @RequestParam(required = false, name="starRating")Integer starRating,
            @RequestParam(required = false, name="customerName")String customerName
    ){
        if (starRating != null){
            List<Course> foundCourses = courseRepository.findByStarRating(starRating);
            return new ResponseEntity(foundCourses, HttpStatus.OK);
        }
        if (customerName != null){
            List<Course> foundCourses = courseRepository.findByBookingsCustomerName(customerName);
            return new ResponseEntity(foundCourses, HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
}
