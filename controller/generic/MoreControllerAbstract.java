package controller.generic;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.Dao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public abstract class MoreControllerAbstract <T> implements Initializable{

	protected T obj;
	
	protected Dao<T> dao;
	
	@FXML 
	protected Button backBtn;

	public Button getBackBtn() {
		return backBtn;
	}


	public void setEntity(T entity) throws SQLException {
		obj = entity;
		init();
	}


	protected void init() throws SQLException {
		setDetail();
		setContribution();
		setLoan();
		setInfraction();
		setOverview();
	}

	protected abstract void setDao() throws SQLException;
	
	protected abstract void setDetail() throws SQLException;

	protected abstract void setContribution();

	protected abstract void setLoan();

	protected abstract void setInfraction();

	protected abstract void setOverview();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
