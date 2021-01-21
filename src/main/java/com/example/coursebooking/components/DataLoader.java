package com.example.coursebooking.components;

import com.example.coursebooking.models.Course;
import com.example.coursebooking.repositories.BookingRepository;
import com.example.coursebooking.repositories.CourseRepository;
import com.example.coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){
        Course course1 = new Course("Software Development For Beginners", "Edinburgh",5 );
        courseRepository.save(course1);

    }
}
