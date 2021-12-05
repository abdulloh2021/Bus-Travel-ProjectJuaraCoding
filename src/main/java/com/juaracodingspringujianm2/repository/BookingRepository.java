package com.juaracodingspringujianm2.repository;





import java.util.List;

import com.juaracodingspringujianm2.model.Booking;
import com.juaracodingspringujianm2.model.Penumpang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository <Booking, Long> {
    @Query(value="DELETE FROM booking WHERE booking.id = ?1",
	nativeQuery = true)
    Booking deleteByIdBooking(Long id);

    @Query(value="SELECT * FROM booking WHERE id_keberangkatan = ?2 AND nik = ?1",
	nativeQuery = true)
    Booking findByNikAndIdkeberangkatan(String nik, long id_keberangkatan);  

    List<Booking> findByNik(Penumpang nik);
}
