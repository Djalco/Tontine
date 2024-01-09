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

public class Contribution /*extends ManagePayment*/{
        private String id;
        private LocalDate createDate;
        private LocalDate lastModifyDate;
        private int amont;
        private String session;
        private String cotisation;

    public String getId() {
        return id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getLastModifyDate() {
        return lastModifyDate;
    }

    public int getAmont() {
        return amont;
    }

    public String getSession() {
        return session;
    }

    public String getCotisation() {
        return cotisation;
    }
	private String sessionContributed;
	
	public Contribution(String id, LocalDate createdDate, LocalDate lastModifyDate, int amont, 
                                    String session, String cotisation, String sessionContributed) {
		//super(id, session, cotisation,ManagePaymentType.CONTRIBUTION.getId());
		this.sessionContributed = sessionContributed;
	}

	public Contribution() {
		super();
	}
        
        
	public Session getSessionContributed() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().find(sessionContributed);
	}

	/*@Override
	public void setEntity(AbstractEntity t) {
		super.createEntity(t);
		Contribution c = (Contribution) t;
		sessionContributed = c.sessionContributed;
		
	}   */
	
	
	

}
