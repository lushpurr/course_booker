package com.example.coursebooking.controllers;

import com.example.coursebooking.models.Course;
import com.example.coursebooking.models.Customer;
import com.example.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name="courseName")String courseName,
            @RequestParam(required = false, name="town")String town,
            @RequestParam(required = false, name="age")Integer age)
    {
        if(age != null && town != null && courseName != null) {
            List<Customer> foundCustomers = customerRepository.findByAgeGreaterThanAndBookingsCourseTownAndBookingsCourseName(age, town, courseName);
            return new ResponseEntity(foundCustomers, HttpStatus.OK);
            }

        if (town != null && courseName != null){
                List<Customer> foundCustomers = customerRepository.findByBookingsCourseTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, courseName);
                return new ResponseEntity(foundCustomers, HttpStatus.OK);
            }
        if (courseName != null){
            List<Customer> foundCustomers = customerRepository.findByBookingsCourseNameIgnoreCase(courseName);
            return new ResponseEntity(foundCustomers, HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
