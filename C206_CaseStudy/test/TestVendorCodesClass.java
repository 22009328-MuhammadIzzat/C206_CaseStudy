import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Venise 22026131, 14 Aug 2023 10:15:53 pm
 */

public class TestVendorCodesClass {
	private Vendor Vendor1;
	private Vendor Vendor2;
	private Vendor Vendor3;
	private ArrayList<Vendor> VendorList;
	
	@Before
	public void setUp() throws Exception {
		Vendor1 = new Vendor("ABCVendor", "Western cuisine", "81568179", "Serangoon Road 123");
		Vendor2 = new Vendor("SunshineVendor", "Malay cuisine", "98627689", "Ang Mo Kio Ave 8");
		Vendor3 = new Vendor("A1Vendor", "Japan cuisine", "87945087", "Jurong West St 15");
		
		VendorList = new ArrayList<Vendor>();
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
	
	@After
	public void tearDown() throws Exception {
	}

}
