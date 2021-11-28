package com.juaracodingspringujianm2.repository;

import java.util.List;

import com.juaracodingspringujianm2.model.Penumpang;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PenumpangRepository extends JpaRepository <Penumpang, Long>{
    List<Penumpang> findByNik(String nik);
}
