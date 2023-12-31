package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import model.enumration.DatePayment;
import model.enumration.ManagePaymentType;

public class ManagePayment extends AbstractEntity{
	private static List<ManagePayment> sessions = new ArrayList<ManagePayment>();
	
    protected int amont;
    protected DatePayment datePayment;
    protected String cotisation;
    protected ManagePaymentType managePaymentType;
    
    public ManagePayment(String id, LocalDate createdDate, LocalDate lastModifyDate, int amont,
			DatePayment datePayment, String cotisation, int managePaymentType) {
		super(id, createdDate, lastModifyDate);
		this.amont = amont;
		this.datePayment = datePayment;
		this.cotisation = cotisation;
		this.managePaymentType = ManagePaymentType.getManagePaymentType(managePaymentType);
		if(!sessions.contains(this)) sessions.add(this);
	}
    
	public ManagePayment() {
		super();
		this.amont = 0;
		this.datePayment = null;
	}

	public int getAmont() {
		return amont;
	}

	public void setAmont(int amont) {
		this.amont = amont;
	}

	public DatePayment getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(DatePayment datePayment) {
		this.datePayment = datePayment;
	}

	public Cotisation getCotisation() throws SQLException {
		return DaoFactory.getCotisationDao().find(cotisation);
	}
	
}
