package model;

import java.time.LocalDate;

import model.enumration.DatePayment;
import model.enumration.PaymentType;

public class Loan extends ManagePayment{
     private static PaymentType paymentType;
    
    public Loan(String id, LocalDate createdDate, LocalDate lastModifyDate, int amont, DatePayment datePayment, String cotisation) {
		super(id, createdDate, lastModifyDate, amont, datePayment, cotisation);
	}

	public Loan() {
		super();
	}

	public void isValidForLoan(User user){
        
    }

	public static PaymentType getPaymentType() {
		return paymentType;
	}

	public static void setPaymentType(PaymentType paymentType) {
		Loan.paymentType = paymentType;
	}
	
	
}