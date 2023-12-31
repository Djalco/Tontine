package model.enumration;

public enum ManagePaymentType {
CONTRIBUTION(1, "Contribution"), LOAN(2, "Pret");
	private String name;
	private int id;
	
	ManagePaymentType(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
	public static ManagePaymentType getManagePaymentType(int id) {
		if(id == 2) return ManagePaymentType.LOAN;
		if(id == 1) return ManagePaymentType.CONTRIBUTION;
		return null;
	}
}
