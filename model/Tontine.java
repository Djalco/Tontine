package model;

import java.util.ArrayList;
import java.util.List;

public class Tontine extends AbstractEntity{
	private static List<Tontine> tontines = new ArrayList<Tontine>();
 
	public Tontine(String id) {
		super(id);
		if(!tontines.contains(this))tontines.add(this);
	}

	public Tontine() {
		super();
	}

	@Override
	public void setEntity(AbstractEntity t) {
		
	}
    
}
