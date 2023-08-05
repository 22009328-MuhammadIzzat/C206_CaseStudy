import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<School> SchoolList = new ArrayList<School>();
		SchoolList.add(new School("CC001", "Sony HDR-CX405", "123"));

		int option = 0;

		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				C206_CaseStudy.schoolManagementMenu();
				int option1 = Helper.readInt("Choose 1 Option: ");
				if (option1 == 1) {
					String name = Helper.readString("Enter School Name: ");
					String Address = Helper.readString("Enter School Address: ");
					String ContactNumber = Helper.readString("Enter School Contact Number: ");
					School ToBeAdded = new School(name, Address, ContactNumber);

					C206_CaseStudy.addSchool(SchoolList, ToBeAdded);
				}
				else if (option1 == 2) {
	                // View all schools
	                C206_CaseStudy.viewAllSchool(SchoolList);
	            }
				else if (option1 == 3) {
	                // Delete a school
	                String name = Helper.readString("Enter School Name to delete: ");
	                C206_CaseStudy.deleteSchoolByName(SchoolList, name);
	            }
			if(option == 2) {
				C206_CaseStudy.viewAllSchool(SchoolList);
			}

			} else if (option == 2) {
				// Add a new item

				C206_CaseStudy.menusManagementMenu();

			} else if (option == 3) {
				// Loan item
				C206_CaseStudy.userManagementMenu();

			} else if (option == 4) {
				C206_CaseStudy.orderManagementMenu();

			} else if (option == 5) {
				C206_CaseStudy.vendorManagementMenu();

			}
		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("School Lunch Box Online Ordering System");
		System.out.println("1. School Management");
		System.out.println("2. Menus Management");
		System.out.println("3. User Management");
		System.out.println("4. Order Management");
		System.out.println("5. Payment Management");
		System.out.println("6. Vendor Management");
		Helper.line(80, "-");
	}

	public static void schoolManagementMenu() {
		System.out.println("School Management Menu:");
		System.out.println("1. Add School");
		System.out.println("2. View School Details");
		System.out.println("3. Delete School");
		Helper.line(80, "-");

	}

	public static void menusManagementMenu() {
		System.out.println("Menus Management Menu:");
		System.out.println("1. Add Menu Item");
		System.out.println("2. View Menu Items");
		System.out.println("3. Delete Menu Item");
		Helper.line(80, "-");

	}

	public static void userManagementMenu() {
		System.out.println("User Management Menu:");
		System.out.println("1. Add User");
		System.out.println("2. View User Details");
		System.out.println("3. Delete User");
		Helper.line(80, "-");

	}

	public static void orderManagementMenu() {
		System.out.println("Order Management Menu:");
		System.out.println("1. Add Order");
		System.out.println("2. View Orders");
		System.out.println("3. Delete Order");
		Helper.line(80, "-");

	}

	public static void vendorManagementMenu() {
		System.out.println("Vendor Management Menu:");
		System.out.println("1. Add Vendor");
		System.out.println("2. View Vendor Details");
		System.out.println("3. Delete Vendor");
		Helper.line(80, "-");
	}

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

	// ================================= Option 1 For school management
	// =================================
	public static void addSchool(ArrayList<School> schoolList, School newSchool) {
		String newSchoolName = newSchool.getSchoolName();

		for (School existingSchool : schoolList) {
			if (existingSchool.getSchoolName().equalsIgnoreCase(newSchoolName)) {
				System.out.println(
						"School with name '" + newSchoolName + "' already exists. Duplicate schools are not allowed.");
				return;
			}
		}

		// If no duplicate is found, add the new school to the list
		schoolList.add(newSchool);
		System.out.println("School '" + newSchoolName + "' has been added.");
	}

	public static String retrieveAllSchool(ArrayList<School> SchoolList) {
		String output = "";

		for (int i = 0; i < SchoolList.size(); i++) {

			output += String.format("%-21s %-21s %-10s\n", SchoolList.get(i).getSchoolName(),
					SchoolList.get(i).getSchoolAddress(), SchoolList.get(i).getContactNumber());

		}
		return output;
	}

	public static void viewAllSchool(ArrayList<School> SchoolList) {
		C206_CaseStudy.setHeader("SCHOOL LIST");
		String output = String.format("%-20s %-20s %-10s\n", "|SCHOOL-NAME|", "|SCHOOL-ADDRESS|", "|SCHOOL-CONTACT-NUMBER|");
		output += retrieveAllSchool(SchoolList);
		System.out.println(output);
	}

	public static void deleteSchoolByName(ArrayList<School> schoolList, String schoolName) {
		for (int i = 0; i < schoolList.size(); i++) {
			School school = schoolList.get(i);
			if (school.getSchoolName().equalsIgnoreCase(schoolName)) {
				schoolList.remove(i);
				System.out.println("School '" + schoolName + "' has been deleted.");
				return;
			}
		}
		System.out.println("School '" + schoolName + "' not found.");
	}

	}

	/*
	  public static void viewAllChromebook(ArrayList<Chromebook> chromebookList) {
	  // write your code here C206_CaseStudy.setHeader("CHROMEBOOK LIST"); String
	  output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG",
	  "DESCRIPTION", "AVAILABLE", "DUE DATE", "OS"); output +=
	  retrieveAllChromebook(chromebookList);
	  
	  System.out.println(output); }
	 
	  // ================================= Option 2 Add an item (CRUD - Create) //
	  ================================= public static Camcorder inputCamcorder() {
	  String tag = Helper.readString("Enter asset tag > "); String description =
	  Helper.readString("Enter description > "); int zoom =
	  Helper.readInt("Enter optical zoom > ");
	  
	  Camcorder cc = new Camcorder(tag, description, zoom); return cc;
	 
	  }
	  
	  public static void addCamcorder(ArrayList<Camcorder> camcorderList, Camcorder
	  cc) { Camcorder item; for (int i = 0; i < camcorderList.size(); i++) { item =
	  camcorderList.get(i); if
	  (item.getAssetTag().equalsIgnoreCase(cc.getAssetTag())) return; } if
	  ((cc.getAssetTag().isEmpty()) || (cc.getDescription().isEmpty())) { return; }
	  
	  camcorderList.add(cc); }
	  
	  public static Chromebook inputChromebook() { String tag =
	  Helper.readString("Enter asset tag > "); String description =
	  Helper.readString("Enter description > "); String os =
	  Helper.readString("Enter os >"); Chromebook cb = new Chromebook(tag,
	  description, os);
	  
	  return cb;
	  
	  }
	  
	  public static void addChromebook(ArrayList<Chromebook> chromebookList,
	  Chromebook cb) { Chromebook item; for (int i = 0; i < chromebookList.size();
	  i++) { item = chromebookList.get(i); if
	  (item.getAssetTag().equalsIgnoreCase(cb.getAssetTag())) return; }
	  
	  if ((cb.getAssetTag().isEmpty()) || (cb.getDescription().isEmpty())) {
	 return; }
	 
	  chromebookList.add(cb);
	  
	  }
	 */
		  
	// ================================= Option 3 User Management (CRUD - Update) //
	 // ================================= public static boolean//
	 	public static void addUsers(ArrayList<Users> usersList, Users newUser) {
		String newUserName = newUser.getName();

		for (Users existingUsers : usersList) {
			if (existingUsers.getName().equalsIgnoreCase(newUserName)) {
				System.out.println(
						"User '" + newUserName + "' already exists. Duplicate Users are not allowed.");
				return;
			}
		}

		// If no duplicate is found, add the new school to the list
		usersList.add(newUser);
		System.out.println("User '" + newUserName + "' has been added.");
	}

	public static String retrieveAllUsers(ArrayList<Users> usersList) {
		String output = "";

		for (int i = 0; i < usersList.size(); i++) {

			output += String.format("%-21s %-21s %-10s\n", usersList.get(i).getName(),
					usersList.get(i).getNric(), usersList.get(i).getContactNumber());

		}
		return output;
	}

	public static void viewAllUsers(ArrayList<Users> usersList) {
		C206_CaseStudy.setHeader("USER LIST");
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

	}
	/*
	  // ================================= Option 4 Return an item (CRUD - //
	  Update)================================= public static boolean
	  doReturnCamcorder(ArrayList<Camcorder> camcorderList, String tag) { boolean
	  isReturned = false;
	  
	  if (tag.isEmpty()) return false;
	 
	  for (int i = 0; i < camcorderList.size(); i++) { if
	  (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag()) &&
	  camcorderList.get(i).getIsAvailable() == false) {
	  camcorderList.get(i).setIsAvailable(true);
	  camcorderList.get(i).setDueDate(""); isReturned = true;
	  
	  } } return isReturned;
	  
	 }
	  
	  public static void returnCamcorder(ArrayList<Camcorder> camcorderList) {
	  C206_CaseStudy.viewAllCamcorder(camcorderList); String tag =
	  Helper.readString("Enter asset tag > "); Boolean isReturned =
	  doReturnCamcorder(camcorderList, tag);
	  
	  if (isReturned == false) { System.out.println("Invalid asset tag"); } else {
	  System.out.println("Camcorder " + tag + " returned"); } }
	  
	  public static boolean doReturnChromebook(ArrayList<Chromebook>
	  chromebookList, String tag) { boolean isReturned = false;
	  
	  if (tag.isEmpty()) return false;
	 
	  for (int i = 0; i < chromebookList.size(); i++) { if
	  (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag()) &&
	  chromebookList.get(i).getIsAvailable() == false) {
	  chromebookList.get(i).setIsAvailable(true);
	  chromebookList.get(i).setDueDate(""); isReturned = true;
	  
	  } } return isReturned;
	  
	  }
	 
	  public static void returnChromebook(ArrayList<Chromebook> chromebookList) {
	  C206_CaseStudy.viewAllChromebook(chromebookList); String tag =
	  Helper.readString("Enter asset tag > "); Boolean isReturned =
	  doReturnChromebook(chromebookList, tag);
	  
	  if (isReturned == false) { System.out.println("Invalid asset tag"); } else {
	  System.out.println("Chromebook " + tag + " returned"); }
	 
	  } }
	 */
