package com.example.coursebooking;

import com.example.coursebooking.models.Booking;
import com.example.coursebooking.models.Course;
import com.example.coursebooking.models.Customer;
import com.example.coursebooking.repositories.BookingRepository;
import com.example.coursebooking.repositories.CourseRepository;
import com.example.coursebooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CoursebookingApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourseByRating(){
		List<Course> foundCourses = courseRepository.findByStarRating(5);
		assertEquals("Software Development For Beginners", foundCourses.get(0).getName());
	}

	@Test
	public void canFindCustomerByCourse(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseNameIgnoreCase("AdvanceD PyThon");
		assertEquals("Gavin", foundCustomers.get(0).getName());
		assertEquals(3, foundCustomers.size());
	}

	@Test
	public void canFindCourseByCustomer(){
		List<Course> foundCourses = courseRepository.findByBookingsCustomerName("Gavin");
		assertEquals(2, foundCourses.size());
		assertEquals("Advanced Python", foundCourses.get(1).getName());
	}

	@Test
	public void canFindBookingByDate(){
		List<Booking> foundBookings = bookingRepository.findByDate("20-01-20");
		assertEquals(1, foundBookings.size());
		assertEquals("Advanced Python", foundBookings.get(0).getCourse().getName());
	}

	@Test
	public void canFindByBookingsCourseTownAndBookingsCourseName(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseTownIgnoreCaseAndBookingsCourseNameIgnoreCase("aviEmore", "aDvanced PYThon");
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canFindByAgeGreaterThanAndBookingsCourseTownAndBookingsCourseName(){
		List<Customer> foundCustomers = customerRepository.findByAgeGreaterThanAndBookingsCourseTownAndBookingsCourseName(35, "Aviemore", "Advanced Python");
		assertEquals(1, foundCustomers.size());
	}


}
