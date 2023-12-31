package model.enumration;

public  enum Role {
    MEMBER(1, "Membre"), SECRETARY(2, "Secretaire"), TREASURER(3, "Tresorier"), PRESIDENT(4, "PRESIDENT");

	private String name;
	private int id;
	
	Role(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public static Role getRole(int id) {
		if(id == 4) return Role.PRESIDENT;
		if(id == 3) return Role.TREASURER;
		if(id == 2) return Role.SECRETARY;
		if(id == 1) return Role.MEMBER;
		return null;
	}
}
