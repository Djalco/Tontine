package model.enumration;


public enum Status{
	PENDING(1,"En attente"), NOTREMBOURSED(2,"Non remboursé"), VALID(3,"Remboursé");

	private String name;
	private int id;
	
	Status(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	public static Status getStatus(int id) {
		if(id == 3) return Status.VALID;
		if(id == 2) return Status.NOTREMBOURSED;
		if(id == 1) return Status.PENDING;
		return null;
	}
//	public static Status getStatus(String name) {
//		if(Role.PRESIDENT.getName().equals(name)) return Role.PRESIDENT;
//		if(Role.TREASURER.getName().equals(name)) return Role.TREASURER;
//		if(Role.SECRETARY.getName().equals(name)) return Role.SECRETARY;
//		if(Role.MEMBER.getName().equals(name)) return Role.MEMBER;
//		return null;
//	}
	
}

