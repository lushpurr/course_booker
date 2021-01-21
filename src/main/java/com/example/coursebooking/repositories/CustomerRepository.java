package com.example.coursebooking.repositories;

import com.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    Get all customers for a given course

    List<Customer> findByBookingsCourseNameIgnoreCase(String courseName);

    //    Get all customers in a given town for a given course
    List<Customer> findByBookingsCourseTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String courseName);


// Get all customers over a certain age in a given town for a given course
    List<Customer> findByAgeGreaterThanAndBookingsCourseTownAndBookingsCourseName(int age, String town, String courseName);

}