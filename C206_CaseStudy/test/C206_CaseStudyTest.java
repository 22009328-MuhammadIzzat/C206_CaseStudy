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

	private ArrayList<School> SchoolList;
	private ArrayList<VendorMenu> menuList;
	private ArrayList<Vendor> VendorList;

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
		
		Vendor1 = new Vendor("ABCVendor", "Western cuisine", "81568179", "Serangoon Road 123");
		Vendor2 = new Vendor("SunshineVendor", "Malay cuisine", "98627689", "Ang Mo Kio Ave 8");
		Vendor3 = new Vendor("A1Vendor", "Japan cuisine", "87945087", "Jurong West St 15");
		
		VendorList = new ArrayList<Vendor>();
	}

	@Test
	public void testAddSchool() {
		// Test Case 1: Normal Condition
			// School list is not null and it is empty
				assertNotNull("Test if there is a valid School arraylist to add to", SchoolList);
				assertEquals("Test that the School arraylist is empty.", 0, SchoolList.size());

			// Given an empty list, after adding 1 item, the size of the list is 1
				C206_CaseStudy.addSchool(SchoolList, School1);
				assertEquals("Test that the School arraylist size is 1.", 1, SchoolList.size());
				
			
		// Test Case 2: Boundary Condition
			// Add another school
				C206_CaseStudy.addSchool(SchoolList, School2);
				assertEquals("Test that the School arraylist size is now 2.", 2, SchoolList.size());

			// The school just added is the same as the last school in the list
				assertSame("Test that School is added to the end of the list.", School2, SchoolList.get(1));

			// Add a school that already exists in the list
				C206_CaseStudy.addSchool(SchoolList, School2);
				assertEquals("Test that the School arraylist size is unchanged.", 2, SchoolList.size());
				
				
		// Test Case 3: Error Condition
			// Add a school with missing details
				School school_missing = new School("School003", "", "98765432");
				C206_CaseStudy.addSchool(SchoolList, school_missing);
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

			// Add a vendor that already exists in the list
				C206_CaseStudy.addVendor(VendorList, Vendor2);
				assertEquals("Test that the Vendor arraylist size is unchanged.", 2, VendorList.size());
				
				
		// Test Case 3: Error Condition
			// Add a vendor with missing details
				Vendor vendor_missing = new Vendor("", "Chinese cuisine", "98765432", "Toa Payoh Ave 4");
				C206_CaseStudy.addVendor(VendorList, vendor_missing);
				assertEquals("Test that the Vendor arraylist size is unchanged.", 2, VendorList.size());
	}


	@Test
	public void testRetrieveAllSchool() {
		// Test Case 1
			// Test if School list is not null and empty
				assertNotNull("Test if there is a valid School arraylist to add to", SchoolList);
				assertEquals("Test that the School arraylist is empty.", 0, SchoolList.size());
				
			// Attempt to retrieve the Schools
				String allSchools = C206_CaseStudy.retrieveAllSchool(SchoolList);
				String testOutput = "";
				
			// Test if the output is empty
				assertEquals("Test that nothing is displayed", testOutput, allSchools);
				
				
		// Test Case 2
				C206_CaseStudy.addSchool(SchoolList, School1);
				C206_CaseStudy.addSchool(SchoolList, School2);
			// Test that the list is not empty
				assertEquals("Test that School arraylist size is 2.", 2, SchoolList.size());
			// Attempt to retrieve the Schools
				allSchools = C206_CaseStudy.retrieveAllSchool(SchoolList);
				testOutput = String.format("%-30s %-30s %-10s\n", "Granite Bay School", "Tampines St 78", "87654321");
				testOutput += String.format("%-30s %-30s %-10s\n", "Good School", "Punggol St 18", "90876545");
			// Test that the details are displayed correctly
				assertEquals("Test that the display is correct.", testOutput, allSchools);
				
				
		// Test Case 3
				School school3 = new School("School003", "", "99999999");
				C206_CaseStudy.addSchool(SchoolList, school3);
			// Attempt to retrieve the Schools
				allSchools = C206_CaseStudy.retrieveAllSchool(SchoolList);
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
				
				
		//Test Case 2
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
				
				
		//Test Case 3
				VendorMenu vendorMenu3 = new VendorMenu("A3", "");
				C206_CaseStudy.addVendorMenu(menuList, vendorMenu3);
			//Attempt to retrieve the menus
				allVendorMenus = C206_CaseStudy.retrieveAllVendorMenu(menuList);
				testOutput = String.format("%-30s %-10s\n", "A1", "Breakfast menu");
				testOutput += String.format("%-30s %-10s\n", "A2", "Lunch menu");
			// Test that the details are displayed correctly
				assertEquals("Test that the display is correct.", testOutput, allVendorMenus);
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
				
				
		//Test Case 2
				C206_CaseStudy.addVendor(VendorList, Vendor1);
				C206_CaseStudy.addVendor(VendorList, Vendor2);
				
			// Test that the list is not empty
				assertEquals("Test that Vendor arraylist size is 2.", 2, VendorList.size());
				
			// Attempt to retrieve the Vendors
				allVendor = C206_CaseStudy.retrieveAllVendor(VendorList);
				testOutput = String.format("%-20s %-25s %-27s %-10s\n", "ABCVendor", "Western cuisine", "81568179", "Serangoon Road 123");
				testOutput += String.format("%-20s %-25s %-27s %-10s\n", "SunshineVendor", "Malay cuisine", "98627689", "Ang Mo Kio Ave 8");
				
			// Test that the details are displayed correctly
				assertEquals("Test that the display is correct.", testOutput, allVendor);
				
				
		//Test Case 3
				Vendor vendor3 = new Vendor("A1Vendor", "Japan cuisine", "", "Jurong West St 15");
				C206_CaseStudy.addVendor(VendorList, vendor3);
			//Attempt to retrieve the vendors
				allVendor = C206_CaseStudy.retrieveAllVendor(VendorList);
				testOutput = String.format("%-20s %-25s %-27s %-10s\n", "ABCVendor", "Western cuisine", "81568179", "Serangoon Road 123");
				testOutput += String.format("%-20s %-25s %-27s %-10s\n", "SunshineVendor", "Malay cuisine", "98627689", "Ang Mo Kio Ave 8");
			// Test that the details are displayed correctly
				assertEquals("Test that the display is correct.", testOutput, allVendor);
	}
	
	@Test
	public void testDeleteSchool() {
		// School list is not null and it is empty
			assertNotNull("Test if there is a valid School arraylist to add to", SchoolList);
			assertEquals("Test that the School arraylist is empty.", 0, SchoolList.size());
			
			
		// Test Case 1: Normal Condition - Delete an existing school by name
			// Add some schools to the SchoolList
				C206_CaseStudy.addSchool(SchoolList, School1);
				C206_CaseStudy.addSchool(SchoolList, School2);
		
			// Delete School 2 by name
				C206_CaseStudy.deleteSchoolByName(SchoolList, "Good School");

			// Check that School 2 is removed from the list
				assertEquals("Test that the SchoolList size is 1 after deleting School B.", 1, SchoolList.size());
				assertFalse("Test that Good School is no longer in the SchoolList.", SchoolList.contains(School2));
				
				
		// Test Case 2: Boundary Condition - Delete the only school in the list

			// Delete the first school (School1) by name
				C206_CaseStudy.deleteSchoolByName(SchoolList, "Granite Bay School");

			// Check that School X is removed from the list
				assertEquals("Test that the SchoolList size is 0 after deleting School 1.",0 , SchoolList.size());
				assertFalse("Test that School1 is no longer in the SchoolList.", SchoolList.contains(School1));
				

		// Test Case 3: Error Condition - Delete a school that does not exist in the
			// list
		

			// Delete a school (School R) that does not exist in the list
				C206_CaseStudy.deleteSchoolByName(SchoolList, "School R");

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
				assertEquals("Test that the menuList size is 0 after deleting VendorMenu 1.",0 , menuList.size());
				assertFalse("Test that VendorMenu1 is no longer in the menuList.", menuList.contains(VendorMenu1));
							
				
		// Test Case 3: Error Condition - Delete a menu that does not exist
			// Delete a Menu (Drinks menu) that does not exist in the list
				C206_CaseStudy.deleteVendorMenuByName(menuList, "Drinks menu");

			// Check that the menuList remains unchanged (no menus are deleted)
				assertEquals("Test that the menuList size is the same after attempting to delete a non-existent menu.", 0, menuList.size());	
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
				assertEquals("Test that the VendorList size is 0 after deleting Vendor1.",0 , VendorList.size());
				assertFalse("Test that Vendor1 is no longer in the vendorList.", VendorList.contains(Vendor1));
							
				
		// Test Case 3: Error Condition - Delete a vendor that does not exist
			// Delete a Vendor (KKVendor) that does not exist in the list
				C206_CaseStudy.deleteVendorByName(VendorList, "KKVendor");

			// Check that the VendorList remains unchanged (no vendors are deleted)
				assertEquals("Test that the VendorList size is the same after attempting to delete a non-existent vendor.", 0, VendorList.size());	
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
