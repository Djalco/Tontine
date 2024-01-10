package model;

import java.sql.SQLException;

import dao.DaoFactory;
import exception.EntityNotFoundException;
import javafx.scene.text.Text;
import model.enumration.PaymentType;
import model.enumration.Status;

public class Loan extends ManagePayment{
	private static PaymentType paymentType;
	private static int value;
	private int amount;
	private String sessionSold;
	private Status status;

	public Loan(String id,  String session, String user, int amount,
			String sessionSold, int status) {
		super(id, session, user);
		this.amount = amount;
		this.sessionSold = sessionSold;
		this.status = Status.getStatus(status);
	}

	public Loan(String id, String user, int amount,
			String sessionSold) throws SQLException {
		super(id, user);
		this.amount = amount;
		this.sessionSold = sessionSold;
		this.status = Status.PENDING;
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

	public int getAmount() {
		return amount;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	public Session getSessionSold() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(sessionSold);
	}

	public Text getStatusColor() throws SQLException, EntityNotFoundException {
		Text t = new Text(DaoFactory.getLoanDao().find(id).status.getName());
		if(status == Status.PENDING)
			t.getStyleClass().add("status-pending");
		else if (status == Status.VALID)
			t.getStyleClass().add("status-good");
		else
			t.getStyleClass().add("status-not-good");
		return t;
	}
	@Override
	public void setEntity(AbstractEntity t) {
		super.createEntity(t);
		Loan l = (Loan) t;
		amount = l.amount;
		sessionSold = l.sessionSold;
	}

	public int getInterest() throws SQLException, EntityNotFoundException {
		int numberSession = DaoFactory.getSessionDao().find(sessionSold).getNumSession()
				- DaoFactory.getSessionDao().find(session).getNumSession();
		if(paymentType == PaymentType.PERCENTAGE) {
			return calculPercentage(numberSession,amount);
		}
		if(paymentType == PaymentType.FIX_SUM)	
			return amount + value*numberSession;
		return -1;
	}

	private int calculPercentage(int val, int sum) {
		if (val==0)
			return sum + sum*value/100;
		return calculPercentage(val-1, sum+sum*value/100);
	}

	public static void setSetting(PaymentType paymentType, int value) {
		Loan.paymentType = paymentType;
		Loan.value = value;
	}



}