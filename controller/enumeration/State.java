package controller.enumeration;

public enum State {

	ADD("Ajout"), DETAIL("Détail"), GESTION("Gestion"), MODIFY("Modification"), MORE("PLus de detail"), NONE(""), OVERVIEW("Vue d'ensemble");
	private String name;

	State(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
