package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import model.enumration.ManagePaymentType;

public class ManagePayment extends AbstractEntity{
	private static List<ManagePayment> sessions = new ArrayList<ManagePayment>();
	
	protected String session;
    protected String user;
    protected ManagePaymentType managePaymentType;
    
    public ManagePayment(String id,
			String session, String user, int managePaymentType) {
		super(id);
		this.session = session;
		this.user = user;
		this.managePaymentType = ManagePaymentType.getManagePaymentType(managePaymentType);
		if(!sessions.contains(this)) sessions.add(this);
	}
    
	public ManagePayment() {
		super();
		this.session = "";
	}

	public Cotisation getCotisation() throws SQLException {
		return DaoFactory.getCotisationDao().find(user);
	}

	public Session getSession() throws SQLException {
		return DaoFactory.getSessionDao().find(session);
	}
	
}
