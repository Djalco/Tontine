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
import model.Contribution;
import model.User;

public class SessionAddContribute implements Initializable{

    @FXML
    private Button cancelBtn;

    @FXML
    private Button mainBtn;


    @FXML
    private ChoiceBox<User> user;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			user.getItems().addAll(DaoFactory.getUserDao().getAll(50));
			user.getSelectionModel().selectFirst();
		} catch (SQLException | EntityNotFoundException e) {
			e.printStackTrace();
		}
		cancelBtn.setOnAction(e->{
			((Stage)cancelBtn.getScene().getWindow()).close();
		});	
		mainBtn.setOnAction(e->{
			try {
				DaoFactory.getContributionDao().create(new Contribution("",user.getSelectionModel().getSelectedItem().getId()));
				((Stage)cancelBtn.getScene().getWindow()).close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (EntityNotFoundException e1) {
				e1.printStackTrace();
			}
		});	
	}

}
