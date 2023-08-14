import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private School School1;
	private School School2;
	private School School3;

	private VendorMenu VendorMenu1;
	private VendorMenu VendorMenu2;
	private VendorMenu VendorMenu3;

	private Vendor Vendor1;
	private Vendor Vendor2;
	private Vendor Vendor3;

	private Order order1;
	private Order order2;
	private Order order3;

	private Users Users1;
	private Users Users2;
	private Users Users3;

	private ArrayList<School> SchoolList;
	private ArrayList<VendorMenu> menuList;
	private ArrayList<Users> UsersList;
	private ArrayList<Vendor> VendorList;
	private ArrayList<Order> orderList;
	public ArrayList<String> menuItems = new ArrayList<>();

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		School1 = new School("Granite Bay School", "Tampines St 78", "87654321");
		School2 = new School("Good School", "Punggol St 18", "90876545");
		School3 = new School("Bright Academy", "Sengkang St 21", "94567890");

		SchoolList = new ArrayList<School>();

		VendorMenu1 = new VendorMenu("A1", "Breakfast menu");
		VendorMenu2 = new VendorMenu("A2", "Lunch menu");
		VendorMenu3 = new VendorMenu("A3", "Dinner menu");

		menuList = new ArrayList<VendorMenu>();

		Users1 = new Users("Jane Tan", "S12345A", "9123456", "T12345A");
		Users2 = new Users("James Lee", "S12345B", "9123457", "T12345B");
		Users3 = new Users("Emily Ong", "S12345C", "9123458", "T12345C");

		UsersList = new ArrayList<Users>();

		Vendor1 = new Vendor("ABCVendor", "Western cuisine", "81568179", "Serangoon Road 123");
		Vendor2 = new Vendor("SunshineVendor", "Malay cuisine", "98627689", "Ang Mo Kio Ave 8");
		Vendor3 = new Vendor("A1Vendor", "Japan cuisine", "87945087", "Jurong West St 15");

		VendorList = new ArrayList<Vendor>();

		menuItems.add("Burger");
		menuItems.add("Fries");
		menuItems.add("Soda");

		order1 = new Order("1", "12/08/2023", menuItems);
		order2 = new Order("2", "13/08/2023", menuItems);
		order3 = new Order("3", "14/08/2023", menuItems);

		orderList = new ArrayList<Order>();

	}

	@Test
	public void testAddSchool() {
		// Test Case 1: Normal Condition
		// School list is not null and it is empty
		assertNotNull("Test if there is a valid School arraylist to add to", SchoolList);
		assertEquals("Test that the School arraylist is empty.", 0, SchoolList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1
		SchoolMethods.addSchool(SchoolList, School1);
		assertEquals("Test that the School arraylist size is 1.", 1, SchoolList.size());

		// Test Case 2: Boundary Condition
		// Add another school
		SchoolMethods.addSchool(SchoolList, School2);
		assertEquals("Test that the School arraylist size is now 2.", 2, SchoolList.size());

		// The school just added is the same as the last school in the list
		assertSame("Test that School is added to the end of the list.", School2, SchoolList.get(1));

		// Add a school that already exists in the list
		SchoolMethods.addSchool(SchoolList, School2);
		assertEquals("Test that the School arraylist size is unchanged.", 2, SchoolList.size());

		// Test Case 3: Error Condition
		// Add a school with missing details
		School school_missing = new School("School003", "", "98765432");
		SchoolMethods.addSchool(SchoolList, school_missing);
		assertEquals("Test that the School arraylist size is unchanged.", 2, SchoolList.size());
	}

	@Test
	public void testAddVendorMenu() {
		// Test Case 1: Normal Condition
		// Menu list is not null and it is empty
		assertNotNull("Test if there is a valid Menu arraylist to add to", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addVendorMenu(menuList, VendorMenu1);
		assertEquals("Test that the Menu arraylist size is 1.", 1, menuList.size());

		// Test Case 2: Boundary Condition
		// Add another menu
		C206_CaseStudy.addVendorMenu(menuList, VendorMenu2);
		assertEquals("Test that the Menu arraylist size is now 2.", 2, menuList.size());

		// The menu just added is the same as the last menu in the list
		assertSame("Test that menu is added to the end of the list.", VendorMenu2, menuList.get(1));

		// Add a menu that already exists in the list
		C206_CaseStudy.addVendorMenu(menuList, VendorMenu2);
		assertEquals("Test that the Menu arraylist size is unchanged.", 2, menuList.size());

		// Test Case 3: Error Condition
		// Add a menu with missing details
		VendorMenu menu_missing = new VendorMenu("", "Dessert menu");
		C206_CaseStudy.addVendorMenu(menuList, menu_missing);
		assertEquals("Test that the Menu arraylist size is unchanged.", 2, menuList.size());
	}

	@Test
	public void testAddUsers() {
		// Test Case 1: Normal Condition
		// School list is not null and it is empty
		assertNotNull("Test if there is a valid User arraylist to add to", UsersList);
		assertEquals("Test that the Users arraylist is empty.", 0, UsersList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addUsers(UsersList, Users1);
		assertEquals("Test that the School arraylist size is 1.", 1, UsersList.size());

		// Test Case 2: Boundary Condition
		// Add another user
		C206_CaseStudy.addUsers(UsersList, Users2);
		assertEquals("Test that the Users arraylist size is now 2.", 2, UsersList.size());

		// The user just added is the same as the last user in the list
		assertSame("Test that User is added to the end of the list.", Users2, UsersList.get(1));

		// Add a user that already exists in the list
		C206_CaseStudy.addUsers(UsersList, Users2);
		assertEquals("Test that the User arraylist size is unchanged.", 2, UsersList.size());

		// Test Case 3: Error Condition
		// Add a user with missing details
		Users users_missing = new Users("User03", "S123458D", "", "T26137D");
		C206_CaseStudy.addUsers(UsersList, users_missing);
		assertEquals("Test that the Users arraylist size is unchanged.", 2, UsersList.size());
	}

	public void testAddVendor() {
		// Test Case 1: Normal Condition
		// Vendor list is not null and it is empty
		assertNotNull("Test if there is a valid Vendor arraylist to add to", VendorList);
		assertEquals("Test that the Vendor arraylist is empty.", 0, VendorList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addVendor(VendorList, Vendor1);
		assertEquals("Test that the Vendor arraylist size is 1.", 1, VendorList.size());

		// Test Case 2: Boundary Condition
		// Add another Vendor
		C206_CaseStudy.addVendor(VendorList, Vendor2);
		assertEquals("Test that the Vendor arraylist size is now 2.", 2, VendorList.size());

		// The vendor just added is the same as the last vendor in the list
		assertSame("Test that vendor is added to the end of the list.", Vendor2, VendorList.get(1));

		// Test Case 3: Boundary Condition
		// Add a vendor that already exists in the list
		C206_CaseStudy.addVendor(VendorList, Vendor2);
		assertEquals("Test that the Vendor arraylist size is unchanged.", 2, VendorList.size());

		// Test Case 4: Error Condition
		// Add a vendor with missing details
		Vendor vendor_missing = new Vendor("", "Chinese cuisine", "98765432", "Toa Payoh Ave 4");
		C206_CaseStudy.addVendor(VendorList, vendor_missing);
		assertEquals("Test that the Vendor arraylist size is unchanged.", 2, VendorList.size());
	}

	@Test
	public void testAddOrder() {
		// Test Case 1: Normal Condition
		// Order list is not null and it is empty
		assertNotNull("Test if there is a valid order list to add to", orderList);
		assertEquals("Test that the order list is empty.", 0, orderList.size());

		// Given an empty list, after adding 1 item, the size of the list is 1.
		C206_CaseStudy.addOrder(orderList, order1);
		assertEquals("Test that the order list size is 1.", 1, orderList.size());

		// Test Case 2: Boundary Condition
		// Add another school
		C206_CaseStudy.addOrder(orderList, order2);
		assertEquals("Test that the order list size is now 2.", 2, orderList.size());

		// Add an order with the same ID, should not change the list size
		C206_CaseStudy.addOrder(orderList, order2);
		assertEquals("Test that the order list size is unchanged.", 2, orderList.size());

		// Test Case 3: Error Condition
		// Add a Order with missing details
		Order order1_missing = new Order("", "12/08/2023", menuItems);
		C206_CaseStudy.addOrder(orderList, order1_missing);
		assertEquals("Test that the Order arraylist size is unchanged.", 2, orderList.size());

	}

	@Test
	public void testRetrieveAllSchool() {
		// Test Case 1
		// Test if School list is not null and empty
		assertNotNull("Test if there is a valid School arraylist to add to", SchoolList);
		assertEquals("Test that the School arraylist is empty.", 0, SchoolList.size());

		// Attempt to retrieve the Schools
		String allSchools = SchoolMethods.retrieveAllSchool(SchoolList);
		String testOutput = "";

		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allSchools);

		// Test Case 2
		SchoolMethods.addSchool(SchoolList, School1);
		SchoolMethods.addSchool(SchoolList, School2);
		// Test that the list is not empty
		assertEquals("Test that School arraylist size is 2.", 2, SchoolList.size());
		// Attempt to retrieve the Schools
		allSchools =SchoolMethods.retrieveAllSchool(SchoolList);
		testOutput = String.format("%-30s %-30s %-10s\n", "Granite Bay School", "Tampines St 78", "87654321");
		testOutput += String.format("%-30s %-30s %-10s\n", "Good School", "Punggol St 18", "90876545");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allSchools);

		// Test Case 3
		School school3 = new School("School003", "", "99999999");
		SchoolMethods.addSchool(SchoolList, school3);
		// Attempt to retrieve the Schools
		allSchools = SchoolMethods.retrieveAllSchool(SchoolList);
		testOutput = String.format("%-30s %-30s %-10s\n", "Granite Bay School", "Tampines St 78", "87654321");
		testOutput += String.format("%-30s %-30s %-10s\n", "Good School", "Punggol St 18", "90876545");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allSchools);

	}

	@Test
	public void testRetrieveAllVendorMenu() {
		// Test Case 1
		// Test if menu list is not null and empty
		assertNotNull("Test if there is a valid Menu arraylist to add to", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());

		// Attempt to retrieve the Menus
		String allVendorMenus = C206_CaseStudy.retrieveAllVendorMenu(menuList);
		String testOutput = "";

		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allVendorMenus);

		// Test Case 2
		C206_CaseStudy.addVendorMenu(menuList, VendorMenu1);
		C206_CaseStudy.addVendorMenu(menuList, VendorMenu2);

		// Test that the list is not empty
		assertEquals("Test that Menu arraylist size is 2.", 2, menuList.size());

		// Attempt to retrieve the Menus
		allVendorMenus = C206_CaseStudy.retrieveAllVendorMenu(menuList);
		testOutput = String.format("%-30s %-10s\n", "A1", "Breakfast menu");
		testOutput += String.format("%-30s %-10s\n", "A2", "Lunch menu");

		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allVendorMenus);

		// Test Case 3
		VendorMenu vendorMenu3 = new VendorMenu("A3", "");
		C206_CaseStudy.addVendorMenu(menuList, vendorMenu3);
		// Attempt to retrieve the menus
		allVendorMenus = C206_CaseStudy.retrieveAllVendorMenu(menuList);
		testOutput = String.format("%-30s %-10s\n", "A1", "Breakfast menu");
		testOutput += String.format("%-30s %-10s\n", "A2", "Lunch menu");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allVendorMenus);
	}

	@Test
	public void testRetrieveAllUsers() {
		// Test Case 1
		// Test if Users list is not null and empty
		assertNotNull("Test if there is a valid Users arraylist to add to", UsersList);
		assertEquals("Test that the User arraylist is empty.", 0, UsersList.size());

		// Attempt to retrieve the Users
		String allUsers = C206_CaseStudy.retrieveAllUsers(UsersList);
		String testOutput = "";

		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allUsers);

		// Test Case 2
		C206_CaseStudy.addUsers(UsersList, Users1);
		C206_CaseStudy.addUsers(UsersList, Users2);

		// Test that the list is not empty
		assertEquals("Test that User arraylist size is 2.", 2, UsersList.size());

		// Attempt to retrieve the Users
		allUsers = C206_CaseStudy.retrieveAllUsers(UsersList);
		testOutput = String.format("%-21s %-21s %-10s\n", "Jane Tan", "S12345A", "9123456");
		testOutput += String.format("%-21s %-21s %-10s\n", "James Lee", "S12345B", "9123457");

		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUsers);

		// Test Case 3
		Users Users3 = new Users("User03", "", "99999999", "T999999A");
		C206_CaseStudy.addUsers(UsersList, Users3);
		// Attempt to retrieve the Users
		allUsers = C206_CaseStudy.retrieveAllUsers(UsersList);
		testOutput = String.format("%-21s %-21s %-10s\n", "Jane Tan", "S12345A", "9123456");
		testOutput += String.format("%-21s %-21s %-10s\n", "James Lee", "S12345B", "9123457");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allUsers);
	}

	@Test
	public void testRetrieveAllVendor() {
		// Test Case 1
		// Test if vendor list is not null and empty
		assertNotNull("Test if there is a valid Vendor arraylist to add to", VendorList);
		assertEquals("Test that the Vendor arraylist is empty.", 0, VendorList.size());

		// Attempt to retrieve the Vendor
		String allVendor = C206_CaseStudy.retrieveAllVendor(VendorList);
		String testOutput = "";

		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allVendor);

		// Test Case 2
		C206_CaseStudy.addVendor(VendorList, Vendor1);
		C206_CaseStudy.addVendor(VendorList, Vendor2);

		// Test that the list is not empty
		assertEquals("Test that Vendor arraylist size is 2.", 2, VendorList.size());

		// Attempt to retrieve the Vendors
		allVendor = C206_CaseStudy.retrieveAllVendor(VendorList);
		testOutput = String.format("%-20s %-25s %-27s %-10s\n", "ABCVendor", "Western cuisine", "81568179",
				"Serangoon Road 123");
		testOutput += String.format("%-20s %-25s %-27s %-10s\n", "SunshineVendor", "Malay cuisine", "98627689",
				"Ang Mo Kio Ave 8");

		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allVendor);

		// Test Case 3
		Vendor vendor3 = new Vendor("A1Vendor", "Japan cuisine", "", "Jurong West St 15");
		C206_CaseStudy.addVendor(VendorList, vendor3);
		// Attempt to retrieve the vendors
		allVendor = C206_CaseStudy.retrieveAllVendor(VendorList);
		testOutput = String.format("%-20s %-25s %-27s %-10s\n", "ABCVendor", "Western cuisine", "81568179",
				"Serangoon Road 123");
		testOutput += String.format("%-20s %-25s %-27s %-10s\n", "SunshineVendor", "Malay cuisine", "98627689",
				"Ang Mo Kio Ave 8");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allVendor);
	}

	@Test
	public void testRetrieveAllOrders() {
		// Test Case 1
		// Test if Order list is not null and empty
		assertNotNull("Test if there is a valid order list to add to", orderList);
		assertEquals("Test that the order list is empty.", 0, orderList.size());
		// Attempt to retrieve the Orders
		String allOrders = C206_CaseStudy.retrieveAllOrders(orderList);
		String testOutput = "";
		// Test if the output if empty
		assertEquals("Test that nothing is displayed", testOutput, allOrders);
		// Test Case 2:
		C206_CaseStudy.addOrder(orderList, order1);
		C206_CaseStudy.addOrder(orderList, order2);
		// Test that the list is not empty
		assertEquals("Test that order list size is 2.", 2, orderList.size());

		// Attempt to retrieve the Orders
		allOrders = C206_CaseStudy.retrieveAllOrders(orderList);
		testOutput = String.format("%-30s %-30s %-10s\n", "1", "12/08/2023", menuItems);
		testOutput += String.format("%-30s %-30s %-10s\n", "2", "13/08/2023", menuItems);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allOrders);

		// Test Case 3
		Order order3 = new Order("10002130123", "", menuItems);
		C206_CaseStudy.addOrder(orderList, order3);
		// Attempt to retrieve the Orders
		allOrders = C206_CaseStudy.retrieveAllOrders(orderList);
		testOutput = String.format("%-30s %-30s %-10s\n", "1", "12/08/2023", menuItems);
		testOutput += String.format("%-30s %-30s %-10s\n", "2", "13/08/2023", menuItems);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allOrders);

	}

	@Test
	public void testDeleteSchool() {
		// School list is not null and it is empty
		assertNotNull("Test if there is a valid School arraylist to add to", SchoolList);
		assertEquals("Test that the School arraylist is empty.", 0, SchoolList.size());

		// Test Case 1: Normal Condition - Delete an existing school by name
		// Add some schools to the SchoolList
		SchoolMethods.addSchool(SchoolList, School1);
		SchoolMethods.addSchool(SchoolList, School2);

		// Delete School 2 by name
		SchoolMethods.deleteSchoolByName(SchoolList, "Good School");

		// Check that School 2 is removed from the list
		assertEquals("Test that the SchoolList size is 1 after deleting School B.", 1, SchoolList.size());
		assertFalse("Test that Good School is no longer in the SchoolList.", SchoolList.contains(School2));

		// Test Case 2: Boundary Condition - Delete the only school in the list

		// Delete the first school (School1) by name
		SchoolMethods.deleteSchoolByName(SchoolList, "Granite Bay School");

		// Check that School X is removed from the list
		assertEquals("Test that the SchoolList size is 0 after deleting School 1.", 0, SchoolList.size());
		assertFalse("Test that School1 is no longer in the SchoolList.", SchoolList.contains(School1));

		// Test Case 3: Error Condition - Delete a school that does not exist in the
		// list

		// Delete a school (School R) that does not exist in the list
		SchoolMethods.deleteSchoolByName(SchoolList, "School R");

		// Check that the SchoolList remains unchanged (no schools are deleted)
		assertEquals("Test that the SchoolList size is  after attempting to delete a non-existent school.", 0,
				SchoolList.size());
	}

	@Test
	public void testDeleteVendorMenu() {
		// Menu list is not null and it is empty
		assertNotNull("Test if there is a valid Menu arraylist to add to", menuList);
		assertEquals("Test that the Menu arraylist is empty.", 0, menuList.size());

		// Test Case 1: Normal Condition - Delete an existing menu by name
		// Add some menus to the MenuList
		C206_CaseStudy.addVendorMenu(menuList, VendorMenu1);
		C206_CaseStudy.addVendorMenu(menuList, VendorMenu2);

		// Delete VendorMenu 2 by name
		C206_CaseStudy.deleteVendorMenuByName(menuList, "Lunch menu");

		// Check that VendorMenu 2 is removed from the list
		assertEquals("Test that the MenuList size is 1 after deleting VendorMenu 2.", 1, menuList.size());
		assertFalse("Test that Lunch menu is no longer in the menuList.", menuList.contains(VendorMenu2));

		// Test Case 2: Boundary Condition - Delete the only school in the list
		// Delete the first menu (VendorMenu1) by name
		C206_CaseStudy.deleteVendorMenuByName(menuList, "Breakfast menu");

		// Check that VendorMenu 1 is removed from the list
		assertEquals("Test that the menuList size is 0 after deleting VendorMenu 1.", 0, menuList.size());
		assertFalse("Test that VendorMenu1 is no longer in the menuList.", menuList.contains(VendorMenu1));

		// Test Case 3: Error Condition - Delete a menu that does not exist
		// Delete a Menu (Drinks menu) that does not exist in the list
		C206_CaseStudy.deleteVendorMenuByName(menuList, "Drinks menu");

		// Check that the menuList remains unchanged (no menus are deleted)
		assertEquals("Test that the menuList size is the same after attempting to delete a non-existent menu.", 0,
				menuList.size());
	}

	@Test
	public void testDeleteVendor() {
		// Vendor list is not null and it is empty
		assertNotNull("Test if there is a valid Vendor arraylist to add to", VendorList);
		assertEquals("Test that the Vendor arraylist is empty.", 0, VendorList.size());

		// Test Case 1: Normal Condition - Delete an existing Vendor by name
		// Add some vendors to the VendorList
		C206_CaseStudy.addVendor(VendorList, Vendor1);
		C206_CaseStudy.addVendor(VendorList, Vendor2);

		// Delete Vendor2 by name
		C206_CaseStudy.deleteVendorByName(VendorList, "SunshineVendor");

		// Check that Vendor2 is removed from the list
		assertEquals("Test that the VendorList size is 1 after deleting Vendor2.", 1, VendorList.size());
		assertFalse("Test that Sunshine Vendor is no longer in the VendorList.", VendorList.contains(Vendor2));

		// Test Case 2: Boundary Condition - Delete the only vendor in the list
		// Delete the first vendor (Vendor1) by name
		C206_CaseStudy.deleteVendorByName(VendorList, "ABCVendor");

		// Check that Vendor1 is removed from the list
		assertEquals("Test that the VendorList size is 0 after deleting Vendor1.", 0, VendorList.size());
		assertFalse("Test that Vendor1 is no longer in the vendorList.", VendorList.contains(Vendor1));

		// Test Case 3: Error Condition - Delete a vendor that does not exist
		// Delete a Vendor (KKVendor) that does not exist in the list
		C206_CaseStudy.deleteVendorByName(VendorList, "KKVendor");

		// Check that the VendorList remains unchanged (no vendors are deleted)
		assertEquals("Test that the VendorList size is the same after attempting to delete a non-existent vendor.", 0,
				VendorList.size());
	}

	@Test
	public void testDeleteOrder() {
		// Order list is not null and it is empty
		assertNotNull("Test if there is a valid order list to add to", orderList);
		assertEquals("Test that the order list is empty.", 0, orderList.size());
		// Test Case 1: Normal Condition - Delete an existing order by order Id
		// Add some orders to the orderList
		C206_CaseStudy.addOrder(orderList, order1);
		C206_CaseStudy.addOrder(orderList, order2);

		// Delete Order 2 by order Id
		C206_CaseStudy.deleteOrderByorderId(orderList, "2");

		// Check the Order 2 is removed from the list
		assertEquals("Test that the order list size is 1 after deleting an order.", 1, orderList.size());
		assertFalse("Test that the deleted order is no longer in the list.", orderList.contains(order2));

		// Test Case 2: Boundary Condition - Delete the only Order in the list
		// Delete the first Order (order1) by order Id
		C206_CaseStudy.deleteOrderByorderId(orderList, "1");

		// Check that Order 1 is removed from the list
		assertEquals("Test that the orderList size is 0 after deleting Order 1. ", 0, orderList.size());
		assertFalse("Test that Order 1 is no longer in the OrderList.", orderList.contains(order1));

		// Test Case 3: Error Condition - Delete a order that does not exist in the list
		// Delete a order (order id - 20) that does not exist in the list
		C206_CaseStudy.deleteOrderByorderId(orderList, "20");

		// Check that the orderList remains unchanged
		assertEquals("Test that the orderList size is the same after attempting to delete a non-existent order.", 0,
				orderList.size());
	}

	@Test
	public void testDeleteUsers() {
		// Users list is not null and it is empty
		assertNotNull("Test if there is a valid Users arraylist to add to", UsersList);
		assertEquals("Test that the Users arraylist is empty.", 0, UsersList.size());

		// Test Case 1: Normal Condition - Delete an existing User by Nric
		// Add some Users to the UsersList
		C206_CaseStudy.addUsers(UsersList, Users1);
		C206_CaseStudy.addUsers(UsersList, Users2);

		// Delete Users 2 by Nric
		C206_CaseStudy.deleteUserByNric(UsersList, "S12345B");

		// Check that Users 2 is removed from the list
		assertEquals("Test that the UsersList size is 1 after deleting VendorMenu 2.", 1, UsersList.size());
		assertFalse("Test that S12345B is no longer in the UsersList.", UsersList.contains(Users2));

		// Test Case 2: Boundary Condition - Delete the only User in the list
		// Delete the first menu (Users1) by Nric
		C206_CaseStudy.deleteUserByNric(UsersList, "S12345A");

		// Check that Users1 is removed from the list
		assertEquals("Test that the UsersList size is 0 after deleting Users 1.", 0, UsersList.size());
		assertFalse("Test that Users1 is no longer in the UsersList.", UsersList.contains(Users1));

		// Test Case 3: Error Condition - Delete a User that does not exist
		// Delete a User (R12345C) that does not exist in the list
		C206_CaseStudy.deleteUserByNric(UsersList, "R12345C");

		// Check that the UsersList remains unchanged (no Users are deleted)
		assertEquals("Test that the UsersList size is the same after attempting to delete a non-existent user.", 0,
				UsersList.size());
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@After
	public void tearDown() throws Exception {
	}

}
