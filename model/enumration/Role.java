package model.enumration;

public  enum Role {
    Member(1, "Membre"), Secretary(2, "Secretaire"), Treasurer(3, "Tresorier"), President(4, "President");

	private String name;
	private int id;
	
	Role(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public Role findRole(int id) {
		if(id == 4) return Role.President;
		if(id == 3) return Role.Treasurer;
		if(id == 2) return Role.Secretary;
		if(id == 1) return Role.Member;
		return null;
	}
}
