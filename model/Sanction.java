package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import model.enumration.InfractionPayment;
import model.enumration.PaymentType;

public class Sanction extends AbstractEntity{
	private static List<Sanction> sanctions = new ArrayList<Sanction>();
	
	private static PaymentType paymentType;
	private InfractionPayment infractionPayment;
	private String sessionStart;
	private String sessionSold;
	
	public Sanction(String id, int infractionPayment,
			String sessionStart, String sessionSold) {
		super(id);
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

	public Session getSessionStart() throws SQLException {
		return DaoFactory.getSessionDao().find(sessionStart);
	}

	public Session getSessionSold() throws SQLException {
		return DaoFactory.getSessionDao().find(sessionSold);
	}
	
	public int getAmount() {
		return 0;
	}

	@Override
	public void setEntity(AbstractEntity t) {
		
	}

}
