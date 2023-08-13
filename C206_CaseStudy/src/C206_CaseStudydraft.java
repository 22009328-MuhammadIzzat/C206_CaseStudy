import java.util.ArrayList;

public class C206_CaseStudydraft {

	public static void main(String[] args) {
		//School ArrayList
		ArrayList<School> SchoolList = new ArrayList<School>();
		SchoolList.add(new School("CC001", "Sony HDR-CX405", "123"));
		
		//Vendor ArrayList
		ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
		VendorList.add(new Vendor("ABCVendor", "Western cuisine", "456", "Serangoon Road 123"));

		int option = 0;

		while (option != 5) {

			C206_CaseStudydraft.mainMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) { // administrator 
				C206_CaseStudydraft.administratorMenu();
				int adOption = Helper.readInt("Choose 1 option: ");
				
				if (adOption == 1) { // schoolManagement
					C206_CaseStudydraft.schoolManagementMenu();
					int schOption = Helper.readInt("Choose 1 Option: ");
					if (schOption == 1) {
						// Add a school
						String name = Helper.readString("Enter School Name: ");
						String Address = Helper.readString("Enter School Address: ");
						String ContactNumber = Helper.readString("Enter School Contact Number: ");
						School ToBeAdded = new School(name, Address, ContactNumber);

						C206_CaseStudydraft.addSchool(SchoolList, ToBeAdded);
						System.out.println("School added");
						
						} else if (schOption == 2) {
							// View all schools
							C206_CaseStudydraft.viewAllSchool(SchoolList);
						
						} else if (schOption == 3){
							// Delete a school
							String name = Helper.readString("Enter School Name to delete: ");
							C206_CaseStudydraft.deleteSchoolByName(SchoolList, name);
							System.out.println("School deleted");
							
						} else {
							System.out.println("Invalid Option!");
						}

				} else if (adOption == 2) { //userManagement
					C206_CaseStudydraft.userManagementMenu();
					int userOption = Helper.readInt("Choose 1 option: ");
					if (userOption == 1) {
						// Add user
						
					} else if (userOption == 2) {
						// View all user
						
					} else if (userOption == 3){
						// Delete user
						
					} else {
						System.out.println("Invalid Option!");
					}
						
				} else if (adOption == 3){ // vendorManagement
					C206_CaseStudydraft.vendorManagementMenu();
					int vendorOption = Helper.readInt("Choose 1 option: ");
					if (vendorOption == 1) {
						// Add vendor
						String vendorName = Helper.readString("Enter Vendor Name: ");
						String vendorDescription = Helper.readString("Enter Description Of Vendor (optional): ");
						String vendorContactNumber = Helper.readString("Enter Vendor's Contact Number: ");
						String vendorAddress = Helper.readString("Enter Vendor's Address: ");
						Vendor vendorToBeAdded = new Vendor(vendorName, vendorDescription, vendorContactNumber, vendorAddress);
						
						C206_CaseStudydraft.addVendor(VendorList, vendorToBeAdded);
						System.out.println("Vendor successfully added");
						
					} else if (vendorOption == 2) { 
						// View all vendors
						C206_CaseStudydraft.viewAllVendor(VendorList);
						
					} else if (vendorOption == 3){
						// Delete a vendor
						String vendorName = Helper.readString("Enter Vendor Name To Delete: ");
						C206_CaseStudydraft.deleteVendorByName(VendorList, vendorName);
						System.out.println("Vendor successfully deleted");
						
					} else {
						System.out.println("Invalid Option!");
					}
				} else {
					System.out.println("Invalid Option!");
				}
				
			} else if (option == 2) { // user 
				C206_CaseStudydraft.userMenu();
				int userOption = Helper.readInt("Choose 1 option: ");
				
				if (userOption == 1) {
					// codes to create new user 
					
				} else if (userOption == 2) { // orderManagement
					C206_CaseStudydraft.orderManagementMenu();
					int userOption1 = Helper.readInt("Choose 1 option: ");
					if (userOption1 == 1) {
						// Add order
						
					} else if (userOption1 == 2) {
						// View all order
						
					} else if (userOption1 == 3){
						// Delete order
						
					} else {
						System.out.println("Invalid Option!");
					}
				
				} else if (userOption == 3) { 
					// View all vendors
					C206_CaseStudydraft.viewAllVendor(VendorList);
				
				} else if (userOption == 4){
					C206_CaseStudydraft.paymentManagementMenu();
					int userOption2 = Helper.readInt("Choose 1 option: ");
					if (userOption2 == 1) {
						// Add payment
					
					} else if (userOption2 == 2){
						// View payment
						
					} else {
						System.out.println("Invalid Option!");
					}
					
				} else {
					System.out.println("Invalid Option!");
				}
				
			} else if (option == 3) { // vendor 
				C206_CaseStudydraft.menusManagementMenu();
				int vendorOption = Helper.readInt("Choose 1 option: ");
				if (vendorOption == 1) {
					// Add menu
					
				} else if (vendorOption == 2) {
					// View menu
				
				} else if (vendorOption == 3){
					// Delete menu
					
				} else {
					System.out.println("Invalid Option!");
				}
			
			} else if (option == 4) { // payment gateway
				System.out.println("Delete payment");
				// codes for delete payment
			
			} else if (option == 5) {
				System.out.println("Thank you for using School Lunch Box Online Ordering System!");
				
			} else {
				System.out.println("Invalid option!");
			}
		}
	}
			
	// main menu / login page
	public static void mainMenu() {
		C206_CaseStudydraft.setHeader("School Lunch Box Online Ordering System Login Page");
		System.out.println("1. Administrator");
		System.out.println("2. User");
		System.out.println("3. Vendor");
		System.out.println("4. Payment Gateway");
		System.out.println("5. End");
	}
	
	// administrator menu
	public static void administratorMenu() {
		System.out.println("1. School Management");;
		System.out.println("2. User Management");;
		System.out.println("3. Vendor Management");
		Helper.line(80, "-");
	}
	
	// user menu
	public static void userMenu() {
		System.out.println("1. Create New User Account");;
		System.out.println("2. Order");
		System.out.println("3. View all vendors");
		System.out.println("4. Payment");
		Helper.line(80, "-");
	}
	

	// start of sub menus for administrators
	public static void schoolManagementMenu() {
		System.out.println("School Management Menu:");
		System.out.println("1. Add a new school");
		System.out.println("2. View all schools");
		System.out.println("3. Delete an existing school");
		Helper.line(80, "-");

	}
	
	public static void userManagementMenu() {
		System.out.println("User Management Menu:");
		System.out.println("1. Add a new user");
		System.out.println("2. View all users");
		System.out.println("3. Delete an existing user");
		Helper.line(80, "-");

	}
	
	public static void vendorManagementMenu() {
		System.out.println("Vendor Management Menu:");
		System.out.println("1. Add a new vendor");
		System.out.println("2. View all vendors");
		System.out.println("3. Delete an existing vendor");
		Helper.line(80, "-");
	}
	// end of sub menus for administrators 
	
	
	// start of sub menus for user 
	public static void orderManagementMenu() {
		System.out.println("Order Management Menu:");
		System.out.println("1. Add a new order");
		System.out.println("2. View all orders");
		System.out.println("3. Delete an existing order");
		Helper.line(80, "-");

	}
	
	public static void paymentManagementMenu() {
		System.out.println("1. Add new payment");
		System.out.println("2. View all payement");
	}
	// end of sub menus for user 
	
	
	// start of sub menus for vendor 
	public static void menusManagementMenu() {
		System.out.println("Menus Management Menu:");
		System.out.println("1. Add a new menu");
		System.out.println("2. View all menus");
		System.out.println("3. Delete an existing menu");
		Helper.line(80, "-");

	}
	// end of sub menus for vendor 

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	// ================================= For school management
	// =================================
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

			output += SchoolList.get(i).toString();

		}
		return output;
	}

	public static void viewAllSchool(ArrayList<School> SchoolList) {
		C206_CaseStudydraft.setHeader("SCHOOL LIST");
		String output = String.format("%-30s %-30s %-10s\n", "SCHOOL-NAME", "SCHOOL-ADDRESS", "SCHOOL-CONTACT-NUMBER");
		output += retrieveAllSchool(SchoolList);
		System.out.println(output);
	}

	public static void deleteSchoolByName(ArrayList<School> schoolList, String schoolName) {
		for (int i = 0; i < schoolList.size(); i++) {
			School school = schoolList.get(i);
			//Check if School is in the system
			Boolean SchoolNameInSystem = school.getSchoolName().equalsIgnoreCase(schoolName);
			
			if (SchoolNameInSystem) {
				schoolList.remove(i);
				return;
			}
		}
	}

	// ================================= For user management 
	// ================================= 
	public static void addUsers(ArrayList<Users> usersList, Users newUser) {
		String newUserName = newUser.getName();

		for (Users existingUsers : usersList) {
			if (existingUsers.getName().equalsIgnoreCase(newUserName)) {
				System.out.println("User '" + newUserName + "' already exists. Duplicate Users are not allowed.");
				return;
			}
		}

		// If no duplicate is found, add the new user to the list
		usersList.add(newUser);
		System.out.println("User '" + newUserName + "' has been added.");
	}

	public static String retrieveAllUsers(ArrayList<Users> usersList) {
		String output = "";

		for (int i = 0; i < usersList.size(); i++) {

			output += String.format("%-21s %-21s %-10s\n", usersList.get(i).getName(), usersList.get(i).getNric(),
					usersList.get(i).getContactNumber());

		}
		return output;
	}

	public static void viewAllUsers(ArrayList<Users> usersList) {
		C206_CaseStudydraft.setHeader("USER LIST");
		String output = String.format("%-20s %-20s %-10s\n", "|USER-NAME|", "|USER-NRIC|", "|USER-CONTACT-NUMBER|");
		output += retrieveAllUsers(usersList);
		System.out.println(output);
	}

	public static void deleteUserByNric(ArrayList<Users> usersList, String nric) {
		for (int i = 0; i < usersList.size(); i++) {
			Users user = usersList.get(i);
			if (user.getNric().equalsIgnoreCase(nric)) {
				usersList.remove(i);
				System.out.println("User '" + user.getName() + "' has been deleted.");
				return;
			}
		}
		System.out.println("User '" + nric + "' not found.");
	}

	// ================================= For menu management
	// =================================
	
	// ================================= For order management
	// =================================
	
	// ================================= For payment management
	// =================================

	// ================================= For vendor management
	// =================================
	public static void addVendor(ArrayList<Vendor> VendorList, Vendor newVendor) {
		String newVendorName = newVendor.getVendorName();

		for (Vendor existingVendor : VendorList) {
			if (existingVendor.getVendorName().equalsIgnoreCase(newVendorName)) {
				System.out.println("Vendor '" + newVendorName + "' already exists. Duplicate names are not allowed.");
				return;
			}
			Boolean isVendorNameEmpty = newVendor.getVendorName().isEmpty();
			Boolean isVendorContactNumberEmpty = newVendor.getContactNumber().isEmpty();
			Boolean isVendorAddressEmpty = newVendor.getAddress().isEmpty();
			if (isVendorNameEmpty || isVendorContactNumberEmpty || isVendorAddressEmpty) {
				System.out.println("Please fill in all neccessary fields!");
				return;
			}
		}
		
		// If no duplicate is found, add the new vendor to the list
		VendorList.add(newVendor);

		}

		public static String retrieveAllVendor(ArrayList<Vendor> VendorList) {
			String output = "";

			for (int i = 0; i < VendorList.size(); i++) {

				output += String.format("%-20s %-25s %-27s %-10s\n", VendorList.get(i).getVendorName(), VendorList.get(i).getDescription(),
						VendorList.get(i).getContactNumber(), VendorList.get(i).getAddress());

			}
			return output;
		}

		public static void viewAllVendor(ArrayList<Vendor> VendorList) {
			C206_CaseStudydraft.setHeader("VENDORS LIST");
			String output = String.format("%-20s %-25s %-27s %-10s\n", "VENDOR NAME", "VENDOR DESCRIPTION", "VENDOR CONTACT NUMBER", "VENDOR ADDRESS");
			output += retrieveAllVendor(VendorList);
			System.out.println(output);
		}

		public static void deleteVendorByName(ArrayList<Vendor> VendorList, String VendorName) {
			for (int i = 0; i < VendorList.size(); i++) {
				Vendor vendor = VendorList.get(i);
				
				//Check if deleted vendor is still in the system
				Boolean VendorNameInSystem = vendor.getVendorName().equalsIgnoreCase(VendorName);
		
				if (VendorNameInSystem) {
					VendorList.remove(i);
					return;
				}
			}
		}
	}

