package com.cg.hotelMenu.bean;

public class Customer {
	private String CustName;
	private String PhoneNumber;
	private String CustomerId;

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [CustName=" + CustName + ", PhoneNumber=" + PhoneNumber + ", CustomerId=" + CustomerId + "]";
	}

}
