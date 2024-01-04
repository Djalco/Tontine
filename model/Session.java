/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;

public class Session extends AbstractEntity{
	
	private static List<Session> sessions = new ArrayList<Session>();
	
	private int numSession;
	
    protected LocalDate dateSession;

	public Session(String id, int numSession, LocalDate dateSession) {
		super(id);
		this.dateSession = dateSession;
		this.numSession = numSession;
		if(!sessions.contains(this)) sessions.add(this);
	}

	public Session() {
		super();
		this.dateSession = null;
	}
	
	public int getNumSession() {
		return numSession;
	}

	public LocalDate getDateSession() {
		return dateSession;
	}

	public LocalDate getNextSession() {
		return null;
	}
	
	private List<Cotisation> getCotisations() throws SQLException {
		return DaoFactory.getCotisationDao().findBySession(id);
	}

	@Override
	public void setEntity(AbstractEntity t) {
		
	}
	
	
	
	

    
}
