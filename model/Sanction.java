package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import exception.EntityNotFoundException;
import model.enumration.InfractionPayment;
import model.enumration.PaymentType;

public class Sanction extends AbstractEntity{
	private static List<Sanction> sanctions = new ArrayList<Sanction>();
	
	private static PaymentType paymentType;
	private InfractionPayment infractionPayment;
	private String user;
	private String sessionStart;
	private String sessionSold;
	
	public Sanction(String id, int infractionPayment, String user,
			String sessionStart, String sessionSold) {
		super(id);
		this.user = user;
		this.infractionPayment = InfractionPayment.getInfractionPayment(infractionPayment);
		this.sessionStart = sessionStart;
		this.sessionSold = sessionSold;
		if(!sanctions.contains(this)) sanctions.add(this);
	}

	public Sanction() {
		super();
		this.infractionPayment = null;
		this.sessionStart = "";
		this.sessionSold = "";
	}

	public static PaymentType getPaymentType() {
		return paymentType;
	}

	public InfractionPayment getInfractionPayment() {
		return infractionPayment;
	}

	public static List<Sanction> getSanctions() {
		return sanctions;
	}

	public Session getSessionStart() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(sessionStart);
	}

	public Session getSessionSold() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(sessionSold);
	}
	
	public int getAmount() {
		return 0;
	}

	public User getUser() throws SQLException, EntityNotFoundException {
		return DaoFactory.getUserDao().find(user);
	}

	@Override
	public void setEntity(AbstractEntity t) {
		
	}
	
	public static void intiSanctions() throws SQLException, EntityNotFoundException {
		DaoFactory.getSanctionDao().initSanction();
	}

}
