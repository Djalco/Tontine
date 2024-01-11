package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import model.User;
import model.enumration.Role;

public class SidebarController implements Initializable{

	@FXML
	private Button account;

	@FXML
	private TitledPane dasboard;

	@FXML
	private Button loanAdd;

	@FXML
	private Button loanManage;

	@FXML
	private Button loanOverview;

	@FXML
	private TitledPane log;

	@FXML
	private Button memberAdd;

	@FXML
	private Button memberManage;

	@FXML
	private Button memberOverview;

	@FXML
	private Button roleOverview;

	@FXML
	private Button sanctionManage;

	@FXML
	private Button sanctionOverview;

	@FXML
	private Button sessionManage;

	@FXML
	private Button sessionOverview;

	@FXML
	private Button tontine;

	@FXML
	private Button sessionContribute;

	@FXML
	private VBox container;


	public Button account() {
		return account;
	}


	public TitledPane dasboard() {
		return dasboard;
	}


	public Button loanAdd() {
		return loanAdd;
	}


	public Button loanManage() {
		return loanManage;
	}


	public Button loanOverview() {
		return loanOverview;
	}


	public TitledPane log() {
		return log;
	}


	public Button memberAdd() {
		return memberAdd;
	}


	public Button memberManage() {
		return memberManage;
	}


	public Button memberOverview() {
		return memberOverview;
	}


	public Button roleOverview() {
		return roleOverview;
	}


	public Button sanctionManage() {
		return sanctionManage;
	}


	public Button sanctionOverview() {
		return sanctionOverview;
	}


	public Button sessionManage() {
		return sessionManage;
	}


	public Button sessionOverview() {
		return sessionOverview;
	}


	public Button tontine() {
		return tontine;
	}

	public Button getSessionContribute() {
		return sessionContribute;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(User.getUserConnected().getRole().getName());
		if(User.getUserConnected().getRole()!= Role.SECRETARY &&
				User.getUserConnected().getRole()!= Role.PRESIDENT)	{
			container.getChildren().remove(3);
			container.getChildren().remove(3);
			container.getChildren().remove(3);
			((VBox)tontine.getParent()).getChildren().remove(tontine);
		}
	}

}
