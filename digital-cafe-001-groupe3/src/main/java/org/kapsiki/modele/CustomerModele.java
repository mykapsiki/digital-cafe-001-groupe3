package org.kapsiki.modele;
public class CustomerModele {
	
	
	protected int customerNumber;
	protected String customerName;
	protected String contactFirstName;
	protected String contactLastName;
	
	
	/* constructeur */
	public CustomerModele(int customerNumber, String customerName, String contactFirstName, String contactLastName) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
	}
	
	
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
	public String getContactFirstName() {
		return contactFirstName;
	}
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	public String getContactLastName() {
		return contactLastName;
	}
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}
	
	
	
}