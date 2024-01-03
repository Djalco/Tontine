package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.enumeration.State;
import controller.generic.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.User;

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

	private ManageControllerAbstract<User> memberManageControl;
	private EntityControllerAbstract<User> memberControl;
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


	public void backPane(VBox child, ManageControllerAbstract<?> manageController, State state, String message) {
		main.getChildren().clear();
		navigationControl.setManageType(state.getName());
//		manageController
		main.getChildren().addAll(navigation,child);
		VBox.setVgrow(child, Priority.ALWAYS);
		createAndShowPopUp(message);
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
		memberControl.setController(this,memberManageControl);
		memberControl.setPage(memberManage);
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

	public void createAndShowPopUp(String label) {
		Popup popup = new Popup();
		Button closeButton = new Button();
		closeButton.setOnAction(e->{
			popup.hide();
		});
		popup.getContent().add(buildContentPop(label,closeButton));

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5),e -> popup.hide()));
		timeline.play();


		popup.show(((Stage)principal.getScene().getWindow()));
		popup.setX(((Stage)principal.getScene().getWindow()).getX() + ((Stage)principal.getScene().getWindow()).getWidth() - popup.getWidth() -30);
		popup.setY(((Stage)principal.getScene().getWindow()).getY()+50);

		((Stage)principal.getScene().getWindow()).xProperty().addListener((obs, oldVal, newVal) -> {
			popup.setX(((Stage)principal.getScene().getWindow()).getX() + ((Stage)principal.getScene().getWindow()).getWidth() - popup.getWidth() -30);
		});
		((Stage)principal.getScene().getWindow()).yProperty().addListener((obs, oldVal, newVal) -> {
			popup.setY(((Stage)principal.getScene().getWindow()).getY()+50);
		});

		((Stage)principal.getScene().getWindow()).widthProperty().addListener((obs, oldVal, newVal) -> {
			popup.setX(((Stage)principal.getScene().getWindow()).getX() + ((Stage)principal.getScene().getWindow()).getWidth() - popup.getWidth() -30);
		});
		((Stage)principal.getScene().getWindow()).heightProperty().addListener((obs, oldVal, newVal) -> {
			popup.setY(((Stage)principal.getScene().getWindow()).getY()+50);
		});
	}

	private VBox buildContentPop(String message, Button closeButton) {
		VBox container = new VBox();
		container.getChildren().addAll(new HBox(), new Text(message));
		container.setStyle("-fx-background-radius: 10; "
				+ "-fx-border-radius: 10; "
				+ "-fx-pref-width: 300; "
				+ "-fx-background-color: #fff; "
				+ "-fx-padding: 10; "
				+ "-fx-spacing: 10; "
				+ "-fx-effect: dropshadow( one-pass-box , grey , 8 , 0.0 , 0 , 0 );");

		((HBox) container.getChildren().get(0)).setSpacing(5);
		((HBox) container.getChildren().get(0)).getChildren().addAll(new ImageView(), new Text("Notification"), new HBox(), closeButton);

		System.out.println(System.getProperty("user.dir")+"/src/img/notification.png");
		//		
		((ImageView)((HBox) container.getChildren().get(0)).getChildren().get(0)).setImage(new Image(getClass().getResourceAsStream("/img/notification.png")));
		((ImageView)((HBox) container.getChildren().get(0)).getChildren().get(0)).setFitWidth(20);
		((ImageView)((HBox) container.getChildren().get(0)).getChildren().get(0)).setFitHeight(20);


		((HBox) container.getChildren().get(0)).getChildren().get(1).setStyle("-fx-fill:  #697a8d; "
				+ "-fx-font-weight: bold; "
				+ "-fx-font-size: 17");


		closeButton.setStyle("-fx-background-color: none;");
		closeButton.setGraphic(new ImageView());

		((ImageView)closeButton.getGraphic()).setImage(new Image(getClass().getResourceAsStream("/img/close.png")));
		((ImageView)closeButton.getGraphic()).setFitWidth(16);
		((ImageView)closeButton.getGraphic()).setFitHeight(16);

		container.getChildren().get(1).setStyle("-fx-fill:  #697a8d; "
				+ "-fx-font-size: 15");
		((Text)(container.getChildren().get(1))).setWrappingWidth(300);



		HBox.setHgrow(((HBox)((HBox) container.getChildren().get(0)).getChildren().get(2)), Priority.ALWAYS);
		return container;
	}

}
