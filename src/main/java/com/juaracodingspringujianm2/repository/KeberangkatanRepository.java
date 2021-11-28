package com.juaracodingspringujianm2.repository;

import java.util.List;


import com.juaracodingspringujianm2.model.Keberangkatan;
import com.juaracodingspringujianm2.model.KeberangkatanBus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KeberangkatanRepository extends JpaRepository <Keberangkatan, Long> {
    // List<Keberangkatan> findByTanggalAndTerminalAwal(String tanggal, long id_jurusan);

   
    @Query(value="SELECT keberangkatan.id, bus.nama_perusahaan as perusahaan, keberangkatan.kelas, keberangkatan.harga, keberangkatan.tanggal as waktu, jurusan.deskripsi FROM `keberangkatan` INNER JOIN jurusan ON keberangkatan.id_jurusan = jurusan.id JOIN bus ON keberangkatan.no_polisi = bus.no_polisi WHERE jurusan.terminal_awal = ?1 and keberangkatan.tanggal LIKE %?2%",
	nativeQuery = true)
	List<KeberangkatanBus> findByTerminalAwalAndTanggal(String terminal, String tanggal);
	
    
}
