/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.DaoFactory;
import exception.EntityNotFoundException;
import model.enumration.ManagePaymentType;

public class Contribution extends ManagePayment{

	private static int amount;
	private String sessionContributed;
	
	public Contribution(String id, String user) throws SQLException, EntityNotFoundException {
		super(id,user);
		this.sessionContributed = DaoFactory.getUserDao().getNextSessionContribute(user).getId();
	}
	
	public Contribution(String id, String user, String session, String sessionContributed) throws SQLException, EntityNotFoundException {
		super(id, session, user);
		this.sessionContributed = sessionContributed;
	}

	public Contribution() {
		super();
	}

	public Session getSessionContributed() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(sessionContributed);
	}

	@Override
	public void setEntity(AbstractEntity t) {
		super.createEntity(t);
		Contribution c = (Contribution) t;
		sessionContributed = c.sessionContributed;
		
	}

	public static void setSetting(int amount) {
		Contribution.amount = amount;
	}
	public void setSessionContributed(String sessionContributed) {
		this.sessionContributed = sessionContributed;
	}   
	
	public static int getAmount() {
		return amount;
	}
	
	
	
	

}
