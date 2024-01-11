package controller.generic;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.Dao;
import exception.EntityNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import model.Contribution;
import model.Loan;
import model.Sanction;

public abstract class MoreControllerAbstract <T> implements Initializable{

	protected T obj;
	
	protected Dao<T> dao;
	
	@FXML 
	protected Button backBtn;

    @FXML
    private TableView<Contribution> tableContribution;

    @FXML
    private TableView<Sanction> tableInfraction;

    @FXML
    private TableView<Loan> tableLoan;
    
	public Button getBackBtn() {
		return backBtn;
	}


	public void setEntity(T entity) throws SQLException, EntityNotFoundException {
		obj = entity;
		init();
	}


	protected void init() throws SQLException, EntityNotFoundException {
		setDetail();
		setContribution();
		setLoan();
		setInfraction();
		setOverview();
	}

	protected abstract void setDao() throws SQLException;
	
	protected abstract void setDetail() throws SQLException, EntityNotFoundException;

	protected abstract void setContribution();

	protected abstract void setLoan();

	protected abstract void setInfraction();

	protected abstract void setOverview();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}
