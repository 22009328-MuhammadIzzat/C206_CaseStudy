/**
 * @author Jana
*
 */
public class Users {

	private String name;
	private String nric;
	private String contactNumber;
	private String childNric;

	// Other relevant attributes and methods, getters, and setters.
	public Users(String name, String nric, String contactNumber, String childNric) {
		this.name = name;
		this.nric = nric;
		this.contactNumber = contactNumber;
		this.childNric = childNric;
	}

	public String getName() {
		return name;
	}

	public String getNric() {
		return nric;
	}

	public String getContactNumber() {
		return contactNumber;
		
	}
	public String getChildNric() {
		return childNric;
}

}

