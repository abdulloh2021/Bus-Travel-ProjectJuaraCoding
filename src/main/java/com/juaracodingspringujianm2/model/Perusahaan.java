package com.juaracodingspringujianm2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name ="perusahaan")
public class Perusahaan {
    @Id
	private String nama;
	private String alamat;

}
