package com.juaracodingspringujianm2.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// private long id_keberangkatan;
    // private String nik;
    @ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_keberangkatan",referencedColumnName="id")
	private Keberangkatan id_keberangkatan;

    @ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="nik",referencedColumnName="nik")
	private Penumpang nik;


	

	

}
