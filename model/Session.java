/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import javafx.scene.text.Text;
import model.enumration.Status;

public class Session extends AbstractEntity{
	
	private static List<Session> sessions = new ArrayList<Session>();
	
	private int numSession;
	
    protected LocalDate dateSession;

	public Session(String id, int numSession, LocalDate dateSession) {
		super(id);
		this.dateSession = dateSession;
		this.numSession = numSession;
		if(!sessions.contains(this)) sessions.add(this);
	}

	public Session() {
		super();
		this.dateSession = null;
	}
	
	public int getNumSession() {
		return numSession;
	}

	public LocalDate getDateSession() {
		return dateSession;
	}

	public LocalDate getNextSession() {
		return null;
	}
	
	
	
	public boolean getStatusCotisation() throws SQLException {
		return DaoFactory.getSessionDao().getNotCotisation(id)==0;
	}
	
	public boolean getStatusLoan() throws SQLException {
		return DaoFactory.getSessionDao().getNotLoan(id)==0;
	}
	
	public static Session getActiveSession() throws SQLException {
		return DaoFactory.getSessionDao().getActiveSession();
	}
	
	public static Session getPreviousSession() throws SQLException {
		return DaoFactory.getSessionDao().getPreviousSession();
	}
	public int getCotisation() throws SQLException {
		return DaoFactory.getSessionDao().getCotisation(id);
	}
	public int getNotCotisation() throws SQLException {
		return DaoFactory.getSessionDao().getNotCotisation(id);
	}
	
	public int getLoan() throws SQLException {
		return DaoFactory.getSessionDao().getLoan(id,numSession);
	}
	
	private List<Contribution> getCotisations() throws SQLException {
		return DaoFactory.getContributionDao().findBySession(id);
	}

	public Text getStatusColorContribute() throws SQLException {
		Text t = new Text(getStatusCotisation()?"Valide":"Invalide");
			t.getStyleClass().add(getStatusCotisation()?"status-good":"status-not-good");
		return t;
	}

	public Text getStatusColorLoan() throws SQLException {
		Text t = new Text(getStatusLoan()?"Valide":"Invalide");
			t.getStyleClass().add(getStatusLoan()?"status-good":"status-not-good");
		return t;
	}
	@Override
	public void setEntity(AbstractEntity t) {
		
	}

	@Override
	public String toString() {
		return "Session " + numSession;
	}
	
	
	
	
	

    
}
