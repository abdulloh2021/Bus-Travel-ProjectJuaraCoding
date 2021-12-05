package com.juaracodingspringujianm2.repository;

import java.util.List;

import com.juaracodingspringujianm2.model.Penumpang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PenumpangRepository extends JpaRepository <Penumpang, Long>{
    List<Penumpang> findByNik(String nik);

    @Query(value="SELECT * FROM penumpang WHERE penumpang.nik= ?1 and penumpang.nama= ?2",
	nativeQuery = true)
    List<Penumpang> findByNikAndNama(String nik, String nama);
}
