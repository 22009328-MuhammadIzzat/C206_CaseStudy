/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * venise, 6 Aug 2023 10:57:23 pm
 */

/**
 * @author venise
 *
 */
public class Vendor {

	private String vendorName;
	private String description;
	private String contactNumber;
	private String address;

	// Other relevant attributes and methods, getters, and setters.
	public Vendor(String vendorName, String description, String contactNumber, String address) {
		this.vendorName = vendorName;
		this.description = description;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public String toStringVendor() {
		String VendorInfo = String.format("%-30s %-30s %-30s %-10s\n", vendorName, description, contactNumber, address);
		// Write your codes here
		return VendorInfo;
	}

	public String getVendorName() {
		return vendorName;
	}

	public String getDescription() {
		return description;
	}

	public String getContactNumber() {
		return contactNumber;
	}
	
	public String getAddress() {
		return address;
	}

}
