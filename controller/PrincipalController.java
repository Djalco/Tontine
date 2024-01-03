package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.enumeration.State;
import controller.generic.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PrincipalController implements Initializable{

	private Parent sidebar;
	private SidebarController sidebarControl;

	private VBox dashboard;
	private DashboardController dashboardControl;

	private Parent navigation;
	private NavigationController navigationControl;


	/*All pane for manage member*/
	private VBox memberManage;
	private VBox member;
	private VBox memberMore;
	private VBox memberOverview;

	private ManageControllerAbstract memberManageControl;
	private EntityControllerAbstract memberControl;
	private MoreControllerAbstract memberMoreControl;
	private OverviewControllerAbstract memberOverviewControl;


	/*All pane for manage loan*/
	private VBox loanManage;
	private VBox loanAdd;
	private VBox loanOverview;


	/*All pane for manage sanction*/
	private VBox sanctionManage;
	private VBox sanctionOverview;


	/*All pane for manage session*/
	private VBox sessionManage;
	private VBox sessionAdd;
	private VBox sessionOverview;


	/*All pane for manage role*/
	private VBox roleManage;
	private VBox roleAssign;
	private VBox roleOverview;


	/*All pane for manage log*/
	private VBox log;


	/*All pane for manage setting*/
	private VBox settingManage;
	private VBox account;
	private Parent appSetting;

	@FXML
	private BorderPane principal;

	@FXML
	private VBox main;


	private void switchPane(VBox child, String Entity, State state) {
		main.getChildren().clear();
		navigationControl.setEntity(Entity+"/");
		navigationControl.setManageType(state.getName());
		main.getChildren().addAll(navigation,child);
		VBox.setVgrow(child, Priority.ALWAYS);
	}


	public <T> void switchPane(VBox child, EntityControllerAbstract<T> control, State state, T entity) throws Exception {
		main.getChildren().clear();
		navigationControl.setManageType(state.getName());
		control.setEntity(entity);
		control.setState(state);
		main.getChildren().addAll(navigation,child);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			setNavigation();
			setSidebar();
			setDashboard();
			setMember();


			switchPane(memberManage, "Utilisateur",State.GESTION);
		} catch (IOException e) {
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

	private void setSidebar() throws IOException {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(getClass().getResource("/view/sidebar.fxml"));
		sidebar = load.load();
		sidebarControl = load.getController();

	}

	private void setDashboard() throws IOException {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(getClass().getResource("/view/dashboard.fxml"));
		dashboard = load.load();
		dashboardControl = load.getController();
		sidebarControl.dasboard().setOnMouseClicked(e->{
			switchPane(dashboard, "Dasboard",State.NONE);
		});

	}
	
	

	private void setMember() throws IOException {
		FXMLLoader load1 = new FXMLLoader();
		load1.setLocation(getClass().getResource("/view/user_manage.fxml"));
		memberManage = load1.load();
		memberManageControl = load1.getController();
		sidebarControl.memberManage().setOnAction(e->{
			switchPane(memberManage, "Utilisateur", State.GESTION);
		});
		memberManageControl.getAdd().setOnAction(e->{
			try {
				memberControl.setState(State.ADD);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			switchPane(member,"Utilisateur",State.ADD);
		});

		FXMLLoader load2 = new FXMLLoader();
		load2.setLocation(getClass().getResource("/view/user.fxml"));
		member = load2.load();
		memberControl = load2.getController();
		memberManageControl.setPage(member);
		memberManageControl.setController(this, memberControl);
		sidebarControl.memberAdd().setOnAction(e->{
			try {
				memberControl.setState(State.ADD);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			navigationControl.setEntity("Utilisateur");
			navigationControl.setManageType(State.ADD.getName());
			switchPane(member, "Utilisateur", State.ADD);
		});
		
		memberControl.getBackBtn().setOnAction(e->{
			switchPane(memberManage, "Utilisateur", State.GESTION);
		});
		
		memberControl.getCancelBtn().setOnAction(e->{
			switchPane(memberManage, "Utilisateur", State.GESTION);
		});
		
		memberControl.getMoreBtn().setOnAction(e->{
			switchPane(memberMore, "Utilisateur", State.GESTION);
		});
		

		FXMLLoader load3 = new FXMLLoader();
		load3.setLocation(getClass().getResource("/view/user_more.fxml"));
		memberMore = load3.load();
		memberMoreControl = load3.getController();
		
		memberMoreControl.getBackBtn().setOnAction(e->{
			switchPane(memberManage, "Utilisateur", State.GESTION);
		});
		
		memberMoreControl.getReturnBtn().setOnAction(e->{
			switchPane(memberManage, "Utilisateur", State.GESTION);
		});
		

		FXMLLoader load4 = new FXMLLoader();
		load4.setLocation(getClass().getResource("/view/user_overview.fxml"));
		memberOverview = load4.load();
		memberOverviewControl = load4.getController();
		sidebarControl.memberOverview().setOnAction(e->{
			switchPane(memberOverview, "Utilisateur", State.OVERVIEW);
		});
		
		memberOverviewControl.getBackBtn().setOnAction(e->{
			switchPane(memberManage, "Utilisateur", State.GESTION);
		});
		
		memberOverviewControl.getReturnBtn().setOnAction(e->{
			switchPane(memberManage, "Utilisateur", State.GESTION);
		});

	}

}
