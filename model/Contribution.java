/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

import model.enumration.DatePayment;

public class Contribution extends ManagePayment{

	public Contribution(String id, LocalDate createdDate, LocalDate lastModifyDate, int amont, DatePayment datePayment, String cotisation) {
		super(id, createdDate, lastModifyDate, amont, datePayment, cotisation);
	}

	public Contribution() {
		super();
	}   

}
