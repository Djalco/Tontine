package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DaoFactory;
import exception.EntityNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Loan;
import model.Session;
import model.User;

public class LoanAddContribute implements Initializable{

	@FXML
	private TextField amount;

	@FXML
	private Button cancelBtn;

	@FXML
	private Button mainBtn;

	@FXML
	private ChoiceBox<Session> sessionRemaining;

	@FXML
	private ChoiceBox<User> user;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		amount.textProperty().addListener((observable, oldValue, newValue)-> {

			try {
				int a = Integer.valueOf(newValue);
				if(a<5000) amount.setText(oldValue);
			}catch(Exception a) {
				amount.setText(oldValue);
			}
		});
		amount.setText("5000");
		try {
			user.getItems().addAll(DaoFactory.getUserDao().getAllWithNotLoan(5000));
			sessionRemaining.getItems().addAll(DaoFactory.getSessionDao().getAllAfterActiveSess());
			user.getSelectionModel().selectFirst();
			sessionRemaining.getSelectionModel().selectFirst();
		} catch (SQLException | EntityNotFoundException e) {
			e.printStackTrace();
		}
		cancelBtn.setOnAction(e->{
			((Stage)cancelBtn.getScene().getWindow()).close();
		});	
		mainBtn.setOnAction(e->{
			try {
				DaoFactory.getLoanDao().create(
						new Loan("", user.getSelectionModel().getSelectedItem().getId(), 
								Integer.valueOf(amount.getText()), sessionRemaining.getSelectionModel().getSelectedItem().getId()));
				((Stage)cancelBtn.getScene().getWindow()).close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (EntityNotFoundException e1) {
				e1.printStackTrace();
			}
		});	
	}
}
