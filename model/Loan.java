package model;

import java.sql.SQLException;

import dao.DaoFactory;
import exception.EntityNotFoundException;
import model.enumration.PaymentType;

public class Loan extends ManagePayment{
     private static PaymentType paymentType;
     private int amount;
     private String sessionSold;

	public Loan(String id,  String cotisation, int amount,
			String sessionSold) {
		//super(id, session, cotisation);
		this.amount = amount;
		this.sessionSold = sessionSold;
	}

	public Loan() {
		super();
	}

	public void isValidForLoan(User user){
        
    }

//	public static PaymentType getPaymentType() {
//		return paymentType;
//	}
//
//	public static void setPaymentType(PaymentType paymentType) {
//		Loan.paymentType = paymentType;
//	}

	public int getAmount() {
		return amount;
	}

	public Session getSessionSold() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(sessionSold);
	}

	@Override
	public void setEntity(AbstractEntity t) {
		super.createEntity(t);
		Loan l = (Loan) t;
		amount = l.amount;
		sessionSold = l.sessionSold;
	}   
	
	
	
	
	
}