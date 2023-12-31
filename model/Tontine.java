package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tontine extends AbstractEntity{
	private static List<Tontine> tontines = new ArrayList<Tontine>();
 
	public Tontine(String id, LocalDate createdDate, LocalDate lastModifyDate) {
		super(id, createdDate, lastModifyDate);
		if(!tontines.contains(this))tontines.add(this);
	}

	public Tontine() {
		super();
	}
    
}
