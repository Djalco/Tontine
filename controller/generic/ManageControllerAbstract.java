package controller.generic;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import controller.PrincipalController;
import controller.enumeration.State;
import javafx.util.Callback;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import dao.Dao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.AbstractEntity;
import model.User;

public abstract class ManageControllerAbstract<T> implements Initializable{

	protected Dao<T> dao;

	private VBox page;

	private PrincipalController principal;

	private EntityControllerAbstract<T> entityController;

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

		});
		try {
			setDao();
			initTable();
			addColumn();
			table.setItems(FXCollections.observableArrayList(dao.getAll(15)));
			titleTable.setText(dao.getAll(15).size()+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
							menuBtn.getItems().addAll(new MenuItem("Détail"),new MenuItem("Modifier"),new MenuItem("Supprimer"));
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
									principal.switchPane(page, entityController, State.DETAIL, dao.find(item));
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							});
							menuBtn.getItems().get(1).setOnAction(e->{
								try {
									principal.switchPane(page, entityController, State.MODIFY, dao.find(item));
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							});
							menuBtn.getItems().get(2).setOnAction(e->{

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


}
