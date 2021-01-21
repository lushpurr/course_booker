package com.example.coursebooking.components;

import com.example.coursebooking.models.Booking;
import com.example.coursebooking.models.Course;
import com.example.coursebooking.models.Customer;
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

        Course course2 = new Course("Advanced Python", "Aviemore",3 );
        courseRepository.save(course2);

        Course course3 = new Course("Spring Intermediate", "Perth",4 );
        courseRepository.save(course3);

        Customer customer1 = new Customer("Gavin", "Glasgow", 38);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Ruth", "Edinburgh", 31);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("John", "Aviemore", 36);
        customerRepository.save(customer3);

        Booking booking1 = new Booking("20-01-21", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("20-01-20", course2, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("20-01-21", course3, customer3);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("20-01-15", course2, customer1);
        bookingRepository.save(booking4);

    }
}
