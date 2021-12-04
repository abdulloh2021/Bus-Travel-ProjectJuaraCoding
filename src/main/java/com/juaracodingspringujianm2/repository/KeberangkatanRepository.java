package com.juaracodingspringujianm2.repository;

import java.util.List;


import com.juaracodingspringujianm2.model.Keberangkatan;
import com.juaracodingspringujianm2.model.KeberangkatanBus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KeberangkatanRepository extends JpaRepository <Keberangkatan, Long> {
    // List<Keberangkatan> findByTanggalAndTerminalAwal(String tanggal, long id_jurusan);

   
    @Query(value="SELECT keberangkatan.id, bus.nama_perusahaan as perusahaan, keberangkatan.kelas, keberangkatan.harga, keberangkatan.tanggal as waktu, jurusan.deskripsi FROM `keberangkatan` INNER JOIN jurusan ON keberangkatan.id_jurusan = jurusan.id JOIN bus ON keberangkatan.no_polisi = bus.no_polisi WHERE jurusan.terminal_awal = ?1 and keberangkatan.tanggal LIKE %?2% AND bus.kapasitas > (SELECT COUNT(*) FROM booking WHERE booking.id_keberangkatan = keberangkatan.id)",
	nativeQuery = true)
	List<KeberangkatanBus> findByTerminalAwalAndTanggal(String terminal, String tanggal);
	
    @Query(value="SELECT keberangkatan.id, bus.nama_perusahaan as perusahaan, keberangkatan.kelas, keberangkatan.harga, keberangkatan.tanggal as waktu, jurusan.deskripsi FROM `keberangkatan` INNER JOIN jurusan ON keberangkatan.id_jurusan = jurusan.id JOIN bus ON keberangkatan.no_polisi = bus.no_polisi WHERE jurusan.terminal_awal = ?1 and jurusan.terminal_akhir = ?2 and keberangkatan.tanggal LIKE %?3% AND bus.kapasitas > (SELECT COUNT(*) FROM booking WHERE booking.id_keberangkatan = keberangkatan.id)",
	nativeQuery = true)
	List<KeberangkatanBus> findByTerminalAwalAkhirAndTanggal(String awal, String akhir, String tanggal);
}
