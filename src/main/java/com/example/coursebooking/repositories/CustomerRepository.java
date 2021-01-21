package com.example.coursebooking.repositories;

import com.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    Get all customers for a given course

    List<Customer> findByBookingsCourseName(String courseName);
}

