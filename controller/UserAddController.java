package controller;

import controller.generic.EntityControllerAbstract;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import model.User;

public class UserAddController extends EntityControllerAbstract{

	@FXML
	private Button backBtn;

	@FXML
	private Button cancelBtn;

	@FXML
	private TextField firstname;

	@FXML
	private TextField lastname;

	@FXML
	private TextField login;

	@FXML
	private TextField mail;

	@FXML
	private Button mainBtn;

	@FXML
	private Button moreBtn;

	@FXML
	private Spinner<?> noms;

	@FXML
	private PasswordField password;

	@FXML
	private TextField phone;

	@FXML
	private ComboBox<?> role;

	@FXML
	private PasswordField verifyPassword;

	@Override
	public Button getBackBtn() {
		return backBtn;
	}

	@Override
	public Button getMainBtn() {
		return mainBtn;
	}

	@Override
	public Button getCancelBtn() {
		return cancelBtn;
	}

	@Override
	public Button getMoreBtn() {
		return moreBtn;
	}

}
