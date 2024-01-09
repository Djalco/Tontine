package model;

import java.sql.SQLException;

import dao.DaoFactory;
import exception.EntityNotFoundException;

public class Cotisation extends AbstractEntity{
	private String user;
	private String session;
	private String managePayment;
	
	public Cotisation(String id, String user, String session) {
		super(id);
		this.user = user;
		this.session = session;
	}

	public User getUser() throws SQLException, EntityNotFoundException {
		return DaoFactory.getUserDao().find(user);
	}

	public Session getSession() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(session);
	}

//	public ManagePayment getManagePayment() throws SQLException, EntityNotFoundException {
//		return (ManagePayment) DaoFactory.getManagePaymentDao().find(managePayment);
//	}

	public void setEntity(AbstractEntity t) {
		Cotisation c = (Cotisation) t;
		user = c.user;
		session = c.session;
		managePayment = c.managePayment;
		
	}

    public void setUser(String user) {
        this.user = user;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setManagePayment(String managePayment) {
        this.managePayment = managePayment;
    }

    @Override
    public String toString() {
        return "Cotisation{" + "user=" + user + ", session=" + session ;
    }
	
	
}
