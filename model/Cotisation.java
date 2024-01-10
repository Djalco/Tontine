package model;

import java.sql.SQLException;

import dao.DaoFactory;
import exception.EntityNotFoundException;

public class Cotisation extends AbstractEntity{
	private String user;
	private String session;
	private String managePayment;
	
	public Cotisation(String id, String user, String session,
			String managePayment) {
		super(id);
		this.user = user;
		this.session = session;
		this.managePayment = managePayment;
	}

	public User getUser() throws SQLException, EntityNotFoundException {
		return DaoFactory.getUserDao().find(user);
	}

	public Session getSession() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(session);
	}

	public ManagePayment getManagePayment() throws SQLException {
		return DaoFactory.getManagePaymentDao().find(managePayment);
	}

	@Override
	public void setEntity(AbstractEntity t) {
		Cotisation c = (Cotisation) t;
		user = c.user;
		session = c.session;
		managePayment = c.managePayment;
		
	}
	
	
}
