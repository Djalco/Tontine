/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

import model.enumration.DatePayment;
import model.enumration.ManagePaymentType;

public class Contribution extends ManagePayment{

	private String id_;
	
	public Contribution(String id1, LocalDate createdDate, LocalDate lastModifyDate, int amont, DatePayment datePayment, String cotisation, String id2) {
		super(id1, createdDate, lastModifyDate, amont, datePayment, cotisation,ManagePaymentType.CONTRIBUTION.getId());
		id = id2;
	}

	public Contribution() {
		super();
		id_ = "";
	}

	public String getId_() {
		return id_;
	}   
	
	

}
