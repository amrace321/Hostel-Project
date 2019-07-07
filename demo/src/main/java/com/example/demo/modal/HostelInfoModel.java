package com.example.demo.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // makes table itself for us
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
	
	

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public String getHostelAddress() {
		return hostelAddress;
	}

	public void setHostelAddress(String hostelAddress) {
		this.hostelAddress = hostelAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	@Override
	public String toString() {
		return "HostelInfoModel [id=" + id + ", hostelName=" + hostelName + ", hostelAddress=" + hostelAddress
				+ ", contact=" + contact + ", price=" + price + ", licenseNumber=" + licenseNumber + ", ownerName="
				+ ownerName + ", imagePath=" + imagePath + "]";
	}
	

}
