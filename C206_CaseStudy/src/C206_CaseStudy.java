import java.util.ArrayList;

public class C206_CaseStudy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<School> SchoolList = new ArrayList<School>();

		SchoolList.add(new School("Bright Academy", "Sengkang St 21", "94567890"));

		//Vendor ArrayList
		ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
		VendorList.add(new Vendor("ABCVendor", "Western cuisine", "456"));

		SchoolList.add(new School("Granite Bay School", "Tampines St 78", "87654321"));


		//User Arraylist 
		ArrayList<Users> UserList = new ArrayList<Users>();
		UserList.add(new Users("Jane Tan","S12345A","9123456","T12345A"));

		//Menu ArrayList
		ArrayList<VendorMenu> menuList = new ArrayList<VendorMenu>();
		menuList.add(new VendorMenu("A1", "Breakfast menu"));

		int option = 0;

		while (option != 5) {

			C206_CaseStudy.mainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) { // administrator
				C206_CaseStudy.administratorMenu();
				int adOption = Helper.readInt("Choose 1 option: ");

				if (adOption == 1) { // schoolManagement
					C206_CaseStudy.schoolManagementMenu();
					int schOption = Helper.readInt("Choose 1 Option: ");
					while (schOption < 1 || schOption > 3) {
						System.out.println("Invalid Option! Please try again.");
						schOption = Helper.readInt("Choose 1 Option: ");
					}
					if (schOption == 1) {
						// Add a school
						C206_CaseStudy.addSchool(SchoolList, C206_CaseStudy.inputSchool());
						System.out.println("School added");

					} else if (schOption == 2) {
						// View all schools
						C206_CaseStudy.viewAllSchool(SchoolList);

					} else if (schOption == 3) {
						// Delete a school
						String nameOfSchooltoDelete = Helper.readString("Enter School Name to delete: ");
						C206_CaseStudy.deleteSchoolByName(SchoolList, nameOfSchooltoDelete);
						System.out.println("School deleted");
					}
				}

				else if (adOption == 2) { // userManagement
					C206_CaseStudy.userManagementMenu();
					int userOption = Helper.readInt("Choose 1 option: ");
					while (userOption < 1 || userOption > 3) {
						System.out.println("Invalid Option! Please try again.");
						userOption = Helper.readInt("Choose 1 Option: ");
					}
					if (userOption == 1) {
						// Add user


						C206_CaseStudy.addUsers(UserList, C206_CaseStudy.inputUsers());
						System.out.println("User has been added");




					} else if (userOption == 2) {
						// View all user

						C206_CaseStudy.viewAllUsers(UserList);


					} else if (userOption == 3) {

						String name = Helper.readString("Enter user Name to delete: ");
						C206_CaseStudy.deleteUserByNric(UserList, name);
						System.out.println("User deleted");

					} else {
						System.out.println("Invalid Option!");

					}

				} else if (adOption == 3) { // vendorManagement
					C206_CaseStudy.vendorManagementMenu();
					int vendorOption = Helper.readInt("Choose 1 option: ");
					while (vendorOption < 1 || vendorOption > 3) {
						System.out.println("Invalid Option! Please try again.");
						vendorOption = Helper.readInt("Choose 1 Option: ");
					}
					if (vendorOption == 1) {
						// Add vendor
						String vendorName = Helper.readString("Enter Vendor Name: ");
						String vendorDescription = Helper.readString("Enter Description Of Vendor (optional): ");
						String vendorContactNumber = Helper.readString("Enter Vendor's Contact Number: ");
						Vendor vendorToBeAdded = new Vendor(vendorName, vendorDescription, vendorContactNumber);

						C206_CaseStudy.addVendor(VendorList, vendorToBeAdded);
						System.out.println("Vendor successfully added");

					} else if (vendorOption == 2) {
						// View all vendors
						C206_CaseStudy.viewAllVendor(VendorList);

					} else if (vendorOption == 3) {
						// Delete a vendor
						String vendorName = Helper.readString("Enter Vendor Name To Delete: ");
						C206_CaseStudy.deleteVendorByName(VendorList, vendorName);
						System.out.println("Vendor successfully deleted");
					}
				}
			}

			if (option == 2) { // user
				C206_CaseStudy.userMenu();
				int userOption = Helper.readInt("Choose 1 option: ");
				while (userOption < 1 || userOption > 4) {
					System.out.println("Invalid Option! Please try again.");
					userOption = Helper.readInt("Choose 1 Option: ");
				}

				if (userOption == 1) {

					// codes to create new user 
					String UserName = Helper.readString("Enter User Name > ");
					String UserNRIC = Helper.readString("Enter User NRIC > ");
					String UserContactNumber = Helper.readString("Enter User Contact Number > ");
					String UserChildNRIC = Helper.readString("Enter User Child NRIC > ");

					Users user = new Users(UserName, UserNRIC, UserContactNumber,UserChildNRIC);
					



				} else if (userOption == 2) { // orderManagement
					C206_CaseStudy.orderManagementMenu();
					int userOption1 = Helper.readInt("Choose 1 option: ");
					while (userOption < 1 || userOption > 4) {
						System.out.println("Invalid Option! Please try again.");
						userOption = Helper.readInt("Choose 1 Option: ");
					}
					if (userOption1 == 1) {
						// Add order

					} else if (userOption1 == 2) {
						// View all order

					} else if (userOption1 == 3) {
						// Delete order

					} 

				} else if (userOption == 3) {
					// View all vendors
					C206_CaseStudy.viewAllVendor(VendorList);

				} else if (userOption == 4) {
					C206_CaseStudy.paymentManagementMenu();
					int userOption2 = Helper.readInt("Choose 1 option: ");
					if (userOption2 == 1) {
						// Add payment

					} else if (userOption2 == 2) {
						// View payment

					}
				}

			} else if (option == 3) { // vendor
				C206_CaseStudy.menusManagementMenu();
				int vendorOption = Helper.readInt("Choose 1 option: ");
				while (vendorOption < 1 || vendorOption > 3) {
					System.out.println("Invalid Option! Please try again.");
					vendorOption = Helper.readInt("Choose 1 Option: ");
				}
				if (vendorOption == 1) {
					// Add menu
					String code = Helper.readString("Enter menu code: ");
					String name = Helper.readString("Enter menu name: ");

					VendorMenu menuToBeAdded = new VendorMenu(code, name);
					C206_CaseStudy.addVendorMenu(menuList, menuToBeAdded);
					System.out.println("Menu successfully added!");

				} else if (vendorOption == 2) {
					// View menu
					C206_CaseStudy.viewAllVendorMenu(menuList);
				} else if (vendorOption == 3) {
					// Delete menu
					String name = Helper.readString("Enter menu name to delete: ");
					C206_CaseStudy.deleteVendorMenuByName(menuList, name);
					System.out.println("Menu successfully deleted!");

				} else if (option == 4) { // payment gateway

					System.out.println("Delete payment");
					// codes for delete payment

				} 
			}
		}System.out.println("Thank you for using School Lunch Box Online Ordering System!");
	}






	// main menu / login page
	public static void mainMenu() {
		C206_CaseStudy.setHeader("School Lunch Box Online Ordering System Login Page");
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



	// ================================= For school management
	// =================================

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

			output += SchoolList.get(i).toString();

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

	// ================================= For user management 
	// ================================= 

	public static Users inputUsers() {
		String UserName = Helper.readString("Enter User Name > ");
		String UserNRIC = Helper.readString("Enter User NRIC > ");
		String UserContactNumber = Helper.readString("Enter User Contact Number > ");
		String UserChildNRIC = Helper.readString("Enter User Child NRIC > ");

		Users user = new Users(UserName, UserNRIC, UserContactNumber,UserChildNRIC);
		return user;

	}
		public static void addUsers(ArrayList<Users> usersList, Users newUsers) {
			String newUserName = newUsers.getName();

			for (Users existingUser : usersList) {
				if (existingUser.getName().equalsIgnoreCase(newUserName)) {
					return;
				}
				Boolean isUserNameEmpty = newUsers.getName().isEmpty();
				Boolean isUserNricEmpty = newUsers.getNric().isEmpty();
				Boolean isContactNumberEmpty = newUsers.getContactNumber().isEmpty();
				Boolean isUserChildNricEmpty = newUsers.getChildNric().isEmpty();
				if (isUserNameEmpty ||  isUserNricEmpty ||  isContactNumberEmpty || isUserChildNricEmpty  ) {
					return;
				}
			}

			// If no duplicate is found, add the new school to the list
			usersList.add(newUsers);

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
				C206_CaseStudy.setHeader("USER LIST");
				String output = String.format("%-20s %-20s %-10s\n", "|USER-NAME|", "|USER-NRIC|", "|USER-CONTACT-NUMBER|");
				output += retrieveAllUsers(usersList);
				System.out.println(output);
			}

			public static void deleteUserByNric(ArrayList<Users> usersList, String userNric) {
				for (int i = 0; i < usersList.size(); i++) {
					Users Users = usersList.get(i);
					// Check if School is in the system
					Boolean UserNricInSystem = Users.getNric().equalsIgnoreCase(userNric);

					if (UserNricInSystem) {
						usersList.remove(i);
						return;
					}
				}
			}

			// ================================= For menu management
			// =================================
			public static void addVendorMenu(ArrayList<VendorMenu> menuList, VendorMenu menuToBeAdded) {
				// TODO Auto-generated method stub
				String newMenuName = menuToBeAdded.getMenuName();

				for(VendorMenu existingMenu : menuList) {
					if (existingMenu.getMenuName().equalsIgnoreCase(newMenuName)) {
						return;
					}

					Boolean isVendorMenuNameEmpty = menuToBeAdded.getMenuName().isEmpty();
					Boolean isMenuCodeEmpty = menuToBeAdded.getMenuCode().isEmpty();
					if (isVendorMenuNameEmpty || isMenuCodeEmpty) {
						System.out.println("Please fill in all neccessary fields!");
						return;
					}
				}
				// If no duplicate is found, add the new vendor to the list
				menuList.add(menuToBeAdded);
			}

			public static String retrieveAllVendorMenu(ArrayList<VendorMenu> menuList) {
				String output = "";

				for (int i = 0; i < menuList.size(); i++) {

					output += menuList.get(i).toString();

				}
				return output;
			}

			public static void viewAllVendorMenu(ArrayList<VendorMenu> menuList) {
				// TODO Auto-generated method stub
				C206_CaseStudy.setHeader("MENU LIST");
				String output = String.format("%-30s %-10s\n", "MENU CODE", "MENU NAME");
				output += retrieveAllVendorMenu(menuList);
				System.out.println(output);

			}

			public static void deleteVendorMenuByName(ArrayList<VendorMenu> menuList, String menuName) {
				// TODO Auto-generated method stub
				for (int i = 0; i < menuList.size(); i++) {
					VendorMenu vendormenu = menuList.get(i);

					//Check if deleted menu is still in the system
					Boolean VendorMenuInSystem = vendormenu.getMenuName().equalsIgnoreCase(menuName);

					if (VendorMenuInSystem) {
						menuList.remove(i);
						return;
					}
				}
			}







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
					if (isVendorNameEmpty || isVendorContactNumberEmpty) {
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

					output += VendorList.get(i).toStringVendor();

				}
				return output;
			}

			public static void viewAllVendor(ArrayList<Vendor> VendorList) {
				C206_CaseStudy.setHeader("VENDORS LIST");
				String output = String.format("%-30s %-30s %-10s\n", "VENDOR-NAME", "VENDOR-DESCRIPTION", "VENDOR-CONTACT-NUMBER");
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



