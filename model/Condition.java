package model;

import java.time.LocalDate;

public class Condition extends AbstractEntity{
	private int nbMaxSanction;
	private int nbMaxlatePayment;
	private int nbMaxlateRemboursement;

	public Condition(String id, LocalDate createdDate, LocalDate lastModifyDate, int nbMaxSanction,
			int nbMaxlatePayment, int nbMaxlateRemboursement) {
		super(id, createdDate, lastModifyDate);
		this.nbMaxSanction = nbMaxSanction;
		this.nbMaxlatePayment = nbMaxlatePayment;
		this.nbMaxlateRemboursement = nbMaxlateRemboursement;
	}

	public Condition() {
		super();
		this.nbMaxSanction = 0;
		this.nbMaxlatePayment = 0;
		this.nbMaxlateRemboursement = 0;
	}

	public int getNbMaxSanction() {
		return nbMaxSanction;
	}

	public void setNbMaxSanction(int nbMaxSanction) {
		this.nbMaxSanction = nbMaxSanction;
	}

	public int getNbMaxlatePayment() {
		return nbMaxlatePayment;
	}

	public void setNbMaxlatePayment(int nbMaxlatePayment) {
		this.nbMaxlatePayment = nbMaxlatePayment;
	}

	public int getNbMaxlateRemboursement() {
		return nbMaxlateRemboursement;
	}

	public void setNbMaxlateRemboursement(int nbMaxlateRemboursement) {
		this.nbMaxlateRemboursement = nbMaxlateRemboursement;
	}



}
