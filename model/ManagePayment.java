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

	public Cotisation getCotisation() throws SQLException, EntityNotFoundException {
		return DaoFactory.getCotisationDao().find(user);
	}

//    public ManagePayment getManagePaymentType() throws SQLException, EntityNotFoundException {
//        return DaoFactory.getManagePaymentDao().find(user);
//    }

	public User getUser() throws SQLException, EntityNotFoundException {
		return DaoFactory.getUserDao().find(user);
	}
        
        public Session getSession() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(session);
	}
	
	public void createEntity(AbstractEntity t) {
		ManagePayment m = (ManagePayment) t;
		session = m.session;
		user = m.user;
		managePaymentType = m.managePaymentType;
	}
	
}
