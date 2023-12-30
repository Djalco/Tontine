package model;

import java.time.LocalDate;

import model.enumration.InfractionPayment;
import model.enumration.PaymentType;

public class Sanction extends AbstractEntity{
	private static PaymentType paymentType;
	private InfractionPayment infractionPayment;
	private LocalDate startDate;
	private LocalDate datePayment;
	
	public Sanction(String id, LocalDate createdDate, LocalDate lastModifyDate, InfractionPayment infractionPayment,
			LocalDate startDate, LocalDate datePayment) {
		super(id, createdDate, lastModifyDate);
		this.infractionPayment = infractionPayment;
		this.startDate = startDate;
		this.datePayment = datePayment;
	}

	public Sanction() {
		super();
		this.infractionPayment = null;
		this.startDate = null;
		this.datePayment = null;
	}

	public static PaymentType getPaymentType() {
		return paymentType;
	}

	public InfractionPayment getInfractionPayment() {
		return infractionPayment;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getDatePayment() {
		return datePayment;
	}

}
