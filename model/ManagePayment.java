package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import exception.EntityNotFoundException;
import model.enumration.ManagePaymentType;

public abstract class ManagePayment extends AbstractEntity{
	private static List<ManagePayment> sessions = new ArrayList<ManagePayment>();
	
	protected String session;
    protected String user;
    protected ManagePaymentType managePaymentType;
    
    public ManagePayment(String id,
			String session, String user) {
		super(id);
		this.session = session;
		this.user = user;
		if(!sessions.contains(this)) sessions.add(this);
	} 
    
    public ManagePayment(String id, String user) throws SQLException {
		super(id);
		this.session = Session.getActiveSession().getId();
		this.user = user;
		if(!sessions.contains(this)) sessions.add(this);
	} 
    
    
	public ManagePayment() {
		super();
		this.session = "";
	}

	public Session getSession() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(session);
	}
	
	
	public static List<ManagePayment> getSessions() {
		return sessions;
	}

	public User getUser() throws SQLException, EntityNotFoundException {
		return DaoFactory.getUserDao().find(user);
	}

	public ManagePaymentType getManagePaymentType() {
		return managePaymentType;
	}

	public void createEntity(AbstractEntity t) {
		ManagePayment m = (ManagePayment) t;
		session = m.session;
		user = m.user;
		managePaymentType = m.managePaymentType;
	}
	
}
