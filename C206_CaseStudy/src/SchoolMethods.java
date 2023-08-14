import java.util.ArrayList;

/**
 * 
 */

/**
 * @author izzat
 *
 */
public class SchoolMethods {
	public static School inputSchool() {
		String SchoolName = Helper.readString("Enter School Name > ");
		String SchoolAddress = Helper.readString("Enter School Address > ");
		String ContactNumber = Helper.readString("Enter Contact Number Of School > ");

		School Sch = new School(SchoolName, SchoolAddress, ContactNumber);
		return Sch;
	}

	public static void addSchool(ArrayList<School> schoolList, School newSchool) {
		String newSchoolName = newSchool.getSchoolName();

		for (School existingSchool : schoolList) {
			if (existingSchool.getSchoolName().equalsIgnoreCase(newSchoolName)) {
				return;
			}
			Boolean isContactNumberEmpty = newSchool.getContactNumber().isEmpty();
			Boolean isAddressOfNewSchoolEmpty = newSchool.getSchoolAddress().isEmpty();
			Boolean isSchoolNameEmpty = newSchool.getSchoolName().isEmpty();
			if (isContactNumberEmpty || isAddressOfNewSchoolEmpty || isSchoolNameEmpty) {
				return;
			}
		}

		// If no duplicate is found, add the new school to the list
		schoolList.add(newSchool);

	}

	public static String retrieveAllSchool(ArrayList<School> SchoolList) {
		String output = "";

		for (int i = 0; i < SchoolList.size(); i++) {

			output += SchoolList.get(i).toStringSchool();

		}
		return output;
	}

	public static void viewAllSchool(ArrayList<School> SchoolList) {
		C206_CaseStudy.setHeader("SCHOOL LIST");
		String output = String.format("%-30s %-30s %-10s\n", "SCHOOL-NAME", "SCHOOL-ADDRESS", "SCHOOL-CONTACT-NUMBER");
		output += retrieveAllSchool(SchoolList);
		System.out.println(output);
	}

	public static void deleteSchoolByName(ArrayList<School> schoolList, String schoolName) {
		for (int i = 0; i < schoolList.size(); i++) {
			School school = schoolList.get(i);
			// Check if School is in the system
			Boolean SchoolNameInSystem = school.getSchoolName().equalsIgnoreCase(schoolName);

			if (SchoolNameInSystem) {
				schoolList.remove(i);
				return;
			}
		}
	}

}
