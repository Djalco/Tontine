package controller.generic;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.PrincipalController;
import controller.SessionAddContribute;
import controller.enumeration.State;
import javafx.util.Callback;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import dao.Dao;
import dao.DaoFactory;
import dao.LoanDao;
import dao.SessionDao;
import exception.EntityNotFoundException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.AbstractEntity;
import model.User;

public abstract class ManageControllerAbstract<T> implements Initializable{

	protected Dao<T> dao;

	Pagination pagination_;

	private VBox page;

	private PrincipalController principal;

	private EntityControllerAbstract<T> entityController;

	private MoreControllerAbstract<T> moreController;

	@FXML
	protected Button btnAdd;

	@FXML
	protected HBox pagination;

	@FXML
	protected Button searchBtn;

	@FXML
	protected ComboBox<?> searchNumResult;

	@FXML
	protected ComboBox<?> searchOrder;

	@FXML
	protected TableView<T> table;

	@FXML
	protected Text titleTable;

	protected abstract void setDao() throws SQLException;

	public Button getAdd() {
		return btnAdd;
	}

	protected abstract List<User> search();

	protected abstract void initTable();

	public void setPage(VBox page) {
		this.page = page;
	}

	public void setController(PrincipalController principal, EntityControllerAbstract<T> entityController) {
		this.principal = principal;
		this.entityController = entityController;
	}
	public void setController(MoreControllerAbstract<T> more) {
		this.moreController = more;
	}

	public void replaceObj(T obj) {
		for(T e: table.getItems())
			if(((AbstractEntity)e).equals((AbstractEntity) obj)){
				((AbstractEntity)e).setEntity((AbstractEntity) obj);

				break;
			}
		for(T e: table.getItems())
			System.out.println(((User)e).getLogin());
		table.refresh();
	}

	public void addObj(T obj) {
		((AbstractEntity) obj).setRow(table.getItems().size()+1);
		table.getItems().add(obj);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnAdd.setOnAction(e->{
			Parent root;
			if((dao instanceof SessionDao))
				try {
					root = FXMLLoader.load(getClass().getResource("/view/session_contribute.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.initOwner((Stage) table.getScene().getWindow());
					stage.initModality(Modality.WINDOW_MODAL);
					stage.setScene(scene);
					stage.showAndWait();
					table.refresh();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if((dao instanceof LoanDao))
				try {
					root = FXMLLoader.load(getClass().getResource("/view/loan_contribute.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.initOwner((Stage) table.getScene().getWindow());
					stage.initModality(Modality.WINDOW_MODAL);
					stage.setScene(scene);
					stage.showAndWait();
					table.refresh();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			//					control.setSession(item);

		});
		try {
			setDao();
			initTable();
			addColumn();
			table.setItems(FXCollections.observableArrayList(dao.getAll(15)));
			titleTable.setText(dao.getAll(15).size()+"");



			int rowCount= dao.getSize() / 15 + 1;
			pagination_ = new Pagination((dao.getSize() / 15 + 1), 0);
			pagination_.setPageFactory(arg01 -> {
				try {
					return createPage(arg01);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (EntityNotFoundException e1) {
					e1.printStackTrace();
				}
				return null;
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		((VBox)table.getParent()).getChildren().add(pagination_);
		VBox.setVgrow(pagination_,Priority.ALWAYS);

	}

	//	public abstract List<MenuItem> getCustomTableButton();

	private void addColumn() {
		TableColumn<T, Integer> index = new TableColumn<T, Integer>();
		TableColumn<T, String> action = new TableColumn<T, String>();

		index.setText("#");
		action.setText("action");

		index.setCellValueFactory(new PropertyValueFactory<T, Integer>("row"));
		action.setCellValueFactory(new PropertyValueFactory<T, String>("id"));

		action.setCellFactory(new Callback<TableColumn<T, String>,TableCell<T, String>> (){

			@Override
			public TableCell<T, String> call(TableColumn<T, String> arg0) {
				return new TableCell<T,String>(){
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(item!=null) {
							MenuButton menuBtn = new MenuButton();
							if(dao instanceof SessionDao)
								menuBtn.getItems().addAll(new MenuItem("Détail")/*,new MenuItem("Ajouter Contribution")*/);
							else if(dao instanceof LoanDao)
								menuBtn.getItems().addAll(new MenuItem("Détail"),new MenuItem("Rembourser"));
							else
								menuBtn.getItems().addAll(new MenuItem("Détail"),new MenuItem("Modfier"));
							HBox hb = new HBox();
							menuBtn.setGraphic(new ImageView());
							((ImageView) menuBtn.getGraphic()).setImage(new Image(getClass().getResourceAsStream("/img/more.png")));
							((ImageView) menuBtn.getGraphic()).setFitWidth(20);
							((ImageView) menuBtn.getGraphic()).setFitHeight(20);
							hb.getChildren().add(menuBtn);
							hb.setAlignment(Pos.CENTER);
							hb.setSpacing(10);
							menuBtn.getItems().get(0).setOnAction(e->{
								try {
									if(!(dao instanceof SessionDao))
										principal.switchPane(page, entityController, State.DETAIL, dao.find(item));
									else {
										moreController.setEntity(dao.find(item));
										principal.switchPane(page, moreController, State.OVERVIEW, dao.find(item));
									}
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							});
							if(!(dao instanceof SessionDao))
								menuBtn.getItems().get(1).setOnAction(e->{
									try {
										Parent root;
										if(dao instanceof LoanDao) {
											((LoanDao)dao).rembourseLoan(item);
											table.refresh();
										}
										else
										principal.switchPane(page, entityController, State.MODIFY, dao.find(item));
									} catch (Exception e1) {
										e1.printStackTrace();
									}
								});
							setGraphic(hb);
						}else {
							setGraphic(null);
						}
					}
				};
			}
		});

		table.getColumns().add(0,index);
		table.getColumns().add(action);

	}


	protected Node createPage(int pageIndex) throws SQLException, EntityNotFoundException {
		int fromIndex = pageIndex * 15;
		int toIndex = Math.min(fromIndex + 15, dao.getSize());
		table.setItems(FXCollections.observableArrayList(dao.getAll(0).subList(fromIndex, toIndex)));
		return new VBox(table);
	}

	public void start() {

	}


}
