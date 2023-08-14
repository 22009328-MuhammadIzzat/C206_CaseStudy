
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * aisya, 14 Aug 2023 10:41:17 pm
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPaymentCodesClass {
	private Payment payment1;
	private Payment payment2;
	private ArrayList<Payment> paymentList;

	@Before
	public void setUp() throws Exception {
		payment1 = new Payment("Credit Card", "347", "12/25", "18364973");
		payment2 = new Payment("Debit Card", "907", "15/27", "87651234");
		paymentList = new ArrayList<Payment>();

	}

	@Test
	public void testAddPayment() {
		// Test Case 1: Normal Condition
		// Payment list is not null and it is empty
		assertNotNull("Test if there is a valid payment list to add to", paymentList);
		assertEquals("Test that the payment list is empty.", 0, paymentList.size());

		// Given an empty list, after adding 1 payment, the size of the list is 1.
		C206_CaseStudy.addPayment(paymentList, payment1);
		assertEquals("Test that the Payment arraylist size is 1.", 1, paymentList.size());

		// Test Case 2: Boundary Condition
		// Add another payment
		C206_CaseStudy.addPayment(paymentList, payment2);
		assertEquals("Test that the payment list size is now 2.", 2, paymentList.size());

		// Test Case 3: Error Condition
		// Add a payment with missing details
		Payment paymentMissinDetails = new Payment("Debit Card", "653", "", "");
		C206_CaseStudy.addPayment(paymentList, paymentMissinDetails);
		assertEquals("Test that the Payment arraylist size is unchanged.", 2, paymentList.size());

	}

	@Test
	public void testRetrieveAllPayment() {
		// Test Case 1
		// Test if Payment list is not null and empty
		assertNotNull("Test if there is a valid payment list to add to", paymentList);
		assertEquals("Test that the payment list is empty.", 0, paymentList.size());

		// Attempt to retrieve Payment
		String allPayment = C206_CaseStudy.retrieveAllPayment(paymentList);
		String testOutput = "";

		// Test if the output if empty
		assertEquals("Test that nothing is displayed", testOutput, allPayment);

		// Test Case 2:
		C206_CaseStudy.addPayment(paymentList, payment1);
		C206_CaseStudy.addPayment(paymentList, payment2);
		// Test that the list is not empty
		assertEquals("Test that payment list size is 2.", 2, paymentList.size());

		// Attempt to retrieve the Payment
		allPayment = C206_CaseStudy.retrieveAllPayment(paymentList);
		testOutput = String.format("%-30s", "Credit Card");
		testOutput += String.format("%-30s", "Debit Card");

		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allPayment);

	}

	@Test
	public void testDeletePayment() {
		// Payment list is not null and it is empty
		assertNotNull("Test if there is a valid payment arraylist to add to", paymentList);
		assertEquals("Test that the payment arraylist is empty.", 0, paymentList.size());

		// Test Case 1: Normal Condition - Delete an existing payment via acc num
		// Add some payment to paymentList
		C206_CaseStudy.addPayment(paymentList, payment1);
		C206_CaseStudy.addPayment(paymentList, payment2);

		// Delete payment by acc num
		C206_CaseStudy.deletePaymentByAccNum(paymentList, "87651234");

		// Check that payment2 is removed from the list
		assertEquals("Test that the paymentList size is 1 after deleting payment", 1, paymentList.size());
		assertFalse("Test that 87651234 is no longer in the paymentList.", paymentList.contains(payment2));

		// Test Case 2: Boundary Condition - Delete payment1 via acc number
		C206_CaseStudy.deletePaymentByAccNum(paymentList, "18364973");

		// Check that payment1 is removed from the list
		assertEquals("Test that the paymentList size is 0 after deleting", 0, paymentList.size());
		assertFalse("Test that payment1 is no longer in the paymentList.", paymentList.contains(payment1));

		// Test Case 3: Error Condition - Delete a payment that does not exist
		// Delete payment (12345678) that does not exist in the list
		C206_CaseStudy.deletePaymentByAccNum(paymentList, "12345678");

		// Check that the paymentList remains unchanged (no payment are deleted)
		assertEquals("Test that the paymentList size is the same after attempting to delete a non-existent payment.", 0,
				paymentList.size());
	}

	@After
	public void tearDown() throws Exception {
	}

}
