package model;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.DaoFactory;
import model.enumration.DatePayment;

public class ManagePayment extends AbstractEntity{
	
    protected int amont;
    protected DatePayment datePayment;
    protected String cotisation;
    
    public ManagePayment(String id, LocalDate createdDate, LocalDate lastModifyDate, int amont,
			DatePayment datePayment, String cotisation) {
		super(id, createdDate, lastModifyDate);
		this.amont = amont;
		this.datePayment = datePayment;
		this.cotisation = cotisation;
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
