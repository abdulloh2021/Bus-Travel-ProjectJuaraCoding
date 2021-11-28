package com.juaracodingspringujianm2.repository;



import com.juaracodingspringujianm2.model.Booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository <Booking, Long> {
    @Query(value="DELETE FROM booking WHERE id = ?1",
	nativeQuery = true)
    Booking deleteByIdBooking(Long id);
}
