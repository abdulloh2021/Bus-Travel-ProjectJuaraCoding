package com.juaracodingspringujianm2.controller;

import java.util.List;

import com.juaracodingspringujianm2.model.Booking;
import com.juaracodingspringujianm2.model.Keberangkatan;
import com.juaracodingspringujianm2.model.KeberangkatanBus;
import com.juaracodingspringujianm2.model.Penumpang;
import com.juaracodingspringujianm2.repository.BookingRepository;
import com.juaracodingspringujianm2.repository.KeberangkatanRepository;
import com.juaracodingspringujianm2.repository.PenumpangRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CariBusController {

    @Autowired
	PenumpangRepository penumpangRepo;

	@Autowired
	KeberangkatanRepository keberangkatanRepo;

	@Autowired
	BookingRepository bookingRepo;

    @GetMapping("/carikeberangkatan")
	public String cariKeberangkatan(Model model, Model model1) {
		model.addAttribute("formCekDataKeberangkatan", new Keberangkatan());
		
		return "tampil";
	}

	
	@PostMapping("/cekkeberangkatan")
	public String cekDataKeberangkatan(@ModelAttribute("formCekDataKeberangkatan") Keberangkatan formCekDataKeberangkatan, Model model){
		List<KeberangkatanBus> dataCekKeberangkatan = keberangkatanRepo.findByTerminalAwalAkhirAndTanggal(formCekDataKeberangkatan.getId_jurusan().getTerminal_awal(),formCekDataKeberangkatan.getId_jurusan().getTerminal_akhir(), formCekDataKeberangkatan.getTanggal()); 
		
		
		if (dataCekKeberangkatan.size() == 0) {
			return "kenihilankeberangkatan";
		} else {
			model.addAttribute("dataCekKeberangkatanList", dataCekKeberangkatan);
			return "tampil";
		}
	}


	
}
