import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private School School1;
	private School School2;
	private School School3;
	
	private ArrayList<School> SchoolList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		School1 = new School("Granite Bay School","Tampines St 78","87654321");
		School2 = new School("Good School", "Punggol St 18", "90876545");
		School3 = new School("Bright Academy", "Sengkang St 21", "94567890");
		
		SchoolList = new ArrayList<School>();
	
	}
	@Test
	public void testAddSchool() {
	    // School list is not null and it is empty
	    assertNotNull("Test if there is a valid School arraylist to add to", SchoolList);
	    assertEquals("Test that the School arraylist is empty.", 0, SchoolList.size());

	    // Given an empty list, after adding 1 item, the size of the list is 1
	    C206_CaseStudy.addSchool(SchoolList, School1);
	    assertEquals("Test that the School arraylist size is 1.", 1, SchoolList.size());

	    // Add another school
	    C206_CaseStudy.addSchool(SchoolList, School2);
	    assertEquals("Test that the School arraylist size is now 2.", 2, SchoolList.size());

	    // The school just added is the same as the last school in the list
	    assertSame("Test that School is added to the end of the list.", School2, SchoolList.get(1));

	    // Add a school that already exists in the list
	    C206_CaseStudy.addSchool(SchoolList, School2);
	    assertEquals("Test that the School arraylist size is unchanged.", 2, SchoolList.size());

	    // Add a school with missing details
	    School school_missing = new School("School003", "", "98765432");
	    C206_CaseStudy.addSchool(SchoolList, school_missing);
	    assertEquals("Test that the School arraylist size is unchanged.", 2, SchoolList.size());
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
	    School school3 = new School("School003", "Woodlands Ave 6", "99999999");
	    SchoolList.add(school3);
	    assertEquals("Test that School arraylist size is 3.", 3, SchoolList.size());
	    // Attempt to retrieve the Schools 
	    allSchools = C206_CaseStudy.retrieveAllSchool(SchoolList);
	    testOutput = String.format("%-30s %-30s %-10s\n", "Granite Bay School", "Tampines St 78", "87654321");
	    testOutput += String.format("%-30s %-30s %-10s\n", "Good School", "Punggol St 18", "90876545");
	    testOutput += String.format("%-30s %-30s %-10s\n", "School003", "Woodlands Ave 6", "99999999");
	    // Test that the details are displayed correctly
	    assertEquals("Test that the display is correct.", testOutput, allSchools);
	}
	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

	@After
	public void tearDown() throws Exception {
	}


}
