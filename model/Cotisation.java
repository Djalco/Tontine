package model;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.DaoFactory;

public class Cotisation extends AbstractEntity{
	private String user;
	private String session;
	private String managePayment;
	
	public Cotisation(String id, LocalDate createdDate, LocalDate lastModifyDate, String user, String session,
			String managePayment) {
		super(id, createdDate, lastModifyDate);
		this.user = user;
		this.session = session;
		this.managePayment = managePayment;
	}

	public User getUser() throws SQLException {
		return DaoFactory.getUserDao().find(user);
	}

	public Session getSession() throws SQLException {
		return DaoFactory.getSessionDao().find(session);
	}

	public ManagePayment getManagePayment() throws SQLException {
		return DaoFactory.getManagePaymentDao().find(managePayment);
	}
	
	
}
