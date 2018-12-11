package com.cg.donor.bean;

import java.util.Date;

public class DonorBean {
	private String donorId;
	private String donorName;
	private String PhoneNumber;
	private String Address;
	//private double donationNumber;
	private Date donationDate;
	private double donationAmount;
	
	public String getDonorId() {
		return donorId;
	}
	public void setDonorId(String donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(double donationAmount) {
		this.donationAmount=donationAmount;
	}
	public Date getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}
	@Override
	public String toString() {
		return "DonorBean [donorId=" + donorId + ", donorName=" + donorName + ", PhoneNumber=" + PhoneNumber
				+ ", Address=" + Address + ", donationNumber=" + donationAmount + ", donationDate=" + donationDate
				+ "]";
	}
	

}
