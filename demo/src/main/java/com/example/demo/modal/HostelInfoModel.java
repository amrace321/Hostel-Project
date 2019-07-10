package com.example.demo.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // makes table itself for us
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HostelInfoModel {
	@Id // Generates primary key for us
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hostelName;
	private String hostelAddress;
	private String contact;
	private String price;
	private String licenseNumber;
	private String ownerName;
	private String imagePath;
	

	

}
