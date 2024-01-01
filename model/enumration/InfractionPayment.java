package model.enumration;

public enum InfractionPayment {
    LATE_PAYMENT(1, "Payement en retard"), LATE_REMBOURSEMENT(2, "Remboursement Pret en retard"),ORTHER(3, "Autre Infraction");

	private String name;
	private int id;
	
	InfractionPayment(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public static InfractionPayment getInfractionPayment(int id) {
		if(id == 3) return InfractionPayment.ORTHER;
		if(id == 2) return InfractionPayment.LATE_REMBOURSEMENT;
		if(id == 1) return InfractionPayment.LATE_PAYMENT;
		return null;
	}
}
