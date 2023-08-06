/**
 * 
 */

/**
 * @author izzat
 *
 */
public class School {

	private String schoolName;
	private String schoolAddress;
	private String contactNumber;

	// Other relevant attributes and methods, getters, and setters.
	public School(String schoolName, String schoolAddress, String contactNumber) {
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
		this.contactNumber = contactNumber;
	}

	public String toString() {
		String itemInfo =  String.format("%-30s %-30s %-10s\n", schoolName,
				schoolAddress, 
				contactNumber
				);
		// Write your codes here
		return itemInfo;
	}
	public String getSchoolName() {
		return schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}
}
