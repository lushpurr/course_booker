package com.example.coursebooking.repositories;

import com.example.coursebooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    //    Get all bookings for a given date
    List<Booking> findByDate(String date);
}

