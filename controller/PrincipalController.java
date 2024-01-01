package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PrincipalController implements Initializable{

	private Parent sidebar;

	private Parent dashboard;
	private DashboardController dashboardControl;
	
	private Parent navigation;
	private NavigationController navigationControl;
	
	
	/*All pane for manage member*/
	private Parent memberManage;
	private Parent memberAdd;
	private Parent memberOverview;
	

	/*All pane for manage loan*/
	private Parent loanManage;
	private Parent loanAdd;
	private Parent loanOverview;
	

	/*All pane for manage sanction*/
	private Parent sanctionManage;
	private Parent sanctionOverview;
	

	/*All pane for manage session*/
	private Parent sessionManage;
	private Parent sessionAdd;
	private Parent sessionOverview;
	

	/*All pane for manage role*/
	private Parent roleManage;
	private Parent roleAssign;
	private Parent roleOverview;
	

	/*All pane for manage log*/
	private Parent log;
	

	/*All pane for manage setting*/
	private Parent settingManage;
	private Parent account;
	private Parent appSetting;

    @FXML
    private BorderPane principal;
    
    @FXML
    private VBox main;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			setNavigation();
			setDashboard();
			sidebar = FXMLLoader.load(getClass().getResource("/view/sidebar.fxml"));
			
			main.getChildren().addAll(navigation,dashboard);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		principal.setLeft(sidebar);
		
	}

	private void setNavigation() throws IOException {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(getClass().getResource("/view/navigation.fxml"));
		navigation = load.load();
		navigationControl = load.getController();
	}

	private void setDashboard() throws IOException {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(getClass().getResource("/view/dashboard.fxml"));
		dashboard = load.load();
		dashboardControl = load.getController();
		
	}

}
