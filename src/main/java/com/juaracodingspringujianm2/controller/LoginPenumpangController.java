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

public class LoginPenumpangController {
    @Autowired
	PenumpangRepository penumpangRepo;

	@Autowired
	KeberangkatanRepository keberangkatanRepo;

	@Autowired
	BookingRepository bookingRepo;


    @GetMapping("/loginpenumpang")
	public String GetLoginPenumpang(Model model) {
		model.addAttribute("formCekData", new Penumpang());
		return "formlogin";
	}
	@PostMapping("/cekpenumpang")
	public String cekPenumpang(@ModelAttribute("formCekData") Penumpang formCekData, Model model){
		List<Penumpang> dataCekPenumpang = penumpangRepo.findByNik(formCekData.getNik()); 
		
		if (dataCekPenumpang.size() == 0) {
			return "kenihilan";
		} else {
			model.addAttribute("dataCekPenumpangList", dataCekPenumpang);
			return "detailpenumpang1";
		}
		
	}
}
