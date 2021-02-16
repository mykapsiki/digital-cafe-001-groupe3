package com.kapsiki.customer.model;

public class CustomerModele 
{
	protected int customerNumber;
	protected String customerName;
	protected String contactLastName;
	protected String contactFirstName;
	protected int phone;
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactLastName() {
		return contactLastName;
	}
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}
	public String getContactFirstName() {
		return contactFirstName;
	}
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "CustomerModele [customerNumber=" + customerNumber + ", customerName=" + customerName
				+ ", contactLastName=" + contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone
				+ "]";
	}

}
