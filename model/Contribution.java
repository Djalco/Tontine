/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.DaoFactory;
import model.enumration.ManagePaymentType;

public class Contribution extends ManagePayment{

	private String sessionContributed;
	
	public Contribution(String id, LocalDate createdDate, LocalDate lastModifyDate, int amont, String session, String cotisation, String sessionContributed) {
		super(id, session, cotisation,ManagePaymentType.CONTRIBUTION.getId());
		this.sessionContributed = sessionContributed;
	}

	public Contribution() {
		super();
	}

	public Session getSessionContributed() throws SQLException {
		return DaoFactory.getSessionDao().find(sessionContributed);
	}   
	
	
	

}
