/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * aisya, 14 Aug 2023 1:33:57 pm
 */

public class Payment {
	private String paymentType;
	private String paymentCvv;
	private String paymentExpDate;
	private String paymentNum;

	// Other relevant attributes and methods, getters, and setters.
	public Payment(String paymentType, String paymentCvv, String paymentExpDate, String paymentNum) {
		this.paymentType = paymentType;
		this.paymentCvv = paymentCvv;
		this.paymentExpDate = paymentExpDate;
		this.paymentNum = paymentNum;
	}
	//to be displayed for payment types
	public String toString() {
		String itemInfo = String.format("%-30s %-30s\n", "Credit Card", "Debit Card");
		return itemInfo;
	}

	public String getPaymentType() {
		return paymentType;

	}

	public String getPaymentCvv() {
		return paymentCvv;
	}

	public String getPaymentExpDate() {
		return paymentExpDate;
	}

	public String getPaymentNum() {
		return paymentNum;
	}

}
