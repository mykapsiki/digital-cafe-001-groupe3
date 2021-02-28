/**
 * 
 */


/**
 * @author TOUSSI
 *
 */
public class Customers {

	protected int customerNumber;
	protected String customerName;
	protected String contactLastName;
	protected String contactFirstName;
	
	public Customers() {	
	}
	
	

	public Customers(int customerNumber, String customerName, String contactLastName, String contactFirstName) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
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


	
	
}
