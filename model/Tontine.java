package model;

import java.time.LocalDate;

public class Tontine extends AbstractEntity{
 
	public Tontine(String id, LocalDate createdDate, LocalDate lastModifyDate) {
		super(id, createdDate, lastModifyDate);
	}

	public Tontine() {
		super();
	}
    
}
