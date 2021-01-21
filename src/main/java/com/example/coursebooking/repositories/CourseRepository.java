package com.example.coursebooking.repositories;

import com.example.coursebooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
//    Get all courses with a given rating

    List<Course> findByStarRating(int starRating);


    //        Get all courses for a given customer

    List<Course> findByBookingsCustomerName(String customerName);


}




