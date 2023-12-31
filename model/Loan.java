package model;

import java.time.LocalDate;

import model.enumration.DatePayment;
import model.enumration.ManagePaymentType;
import model.enumration.PaymentType;

public class Loan extends ManagePayment{
     private static PaymentType paymentType;
     private String id_;
    
    public Loan(String id, LocalDate createdDate, LocalDate lastModifyDate, int amont, DatePayment datePayment, String cotisation, String id_) {
		super(id, createdDate, lastModifyDate, amont, datePayment, cotisation,ManagePaymentType.LOAN.getId());
		this.id_ = id_;
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

	public String getId_() {
		return id_;
	}
	
	
	
	
}