package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
	private VBox memberAdd;
	private VBox memberMore;
	private VBox memberOverview;

	private ManageControllerAbstract memberManageControl;
	private EntityControllerAbstract memberAddControl;
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


	private void switchPane(VBox child) {
		main.getChildren().clear();
		main.getChildren().addAll(navigation,child);
		VBox.setVgrow(child, Priority.ALWAYS);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			setNavigation();
			setSidebar();
			setDashboard();
			setMember();


			switchPane(dashboard);
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
			switchPane(dashboard);
		});

	}

	private void setMember() throws IOException {
		FXMLLoader load1 = new FXMLLoader();
		load1.setLocation(getClass().getResource("/view/user.fxml"));
		memberManage = load1.load();
		memberManageControl = load1.getController();
		sidebarControl.memberManage().setOnMouseClicked(e->{
			switchPane(memberManage);
		});
		memberManageControl.getAdd().setOnMouseClicked(e->{
			switchPane(memberAdd);
		});

		FXMLLoader load2 = new FXMLLoader();
		load2.setLocation(getClass().getResource("/view/user_add.fxml"));
		memberAdd = load2.load();
		memberAddControl = load2.getController();
		sidebarControl.memberAdd().setOnMouseClicked(e->{
			switchPane(memberAdd);
		});
		
		memberAddControl.getBackBtn().setOnMouseClicked(e->{
			switchPane(memberManage);
		});
		
		memberAddControl.getCancelBtn().setOnMouseClicked(e->{
			switchPane(memberManage);
		});
		
		memberAddControl.getMoreBtn().setOnMouseClicked(e->{
			switchPane(memberMore);
		});
		

		FXMLLoader load3 = new FXMLLoader();
		load3.setLocation(getClass().getResource("/view/user_more.fxml"));
		memberMore = load3.load();
		memberMoreControl = load3.getController();
		
		memberMoreControl.getBackBtn().setOnMouseClicked(e->{
			switchPane(memberManage);
		});
		
		memberMoreControl.getReturnBtn().setOnMouseClicked(e->{
			switchPane(memberManage);
		});
		

		FXMLLoader load4 = new FXMLLoader();
		load4.setLocation(getClass().getResource("/view/user_overview.fxml"));
		memberOverview = load4.load();
		memberOverviewControl = load4.getController();
		sidebarControl.memberOverview().setOnMouseClicked(e->{
			switchPane(memberOverview);
		});
		
		memberOverviewControl.getBackBtn().setOnMouseClicked(e->{
			switchPane(memberManage);
		});
		
		memberOverviewControl.getReturnBtn().setOnMouseClicked(e->{
			switchPane(memberManage);
		});

	}

}
