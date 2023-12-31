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
	
    protected LocalDate dateSession;

	public Session(String id, LocalDate createdDate, LocalDate lastModifyDate, LocalDate dateSession) {
		super(id, createdDate, lastModifyDate);
		this.dateSession = dateSession;
		if(!sessions.contains(this)) sessions.add(this);
	}

	public Session() {
		super();
		this.dateSession = null;
	}
	
	private List<Cotisation> getCotisations() throws SQLException {
		return DaoFactory.getCotisationDao().findBySession(id);
	}
	
	
	
	

    
}
