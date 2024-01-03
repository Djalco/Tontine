package controller;

import java.sql.SQLException;
import java.util.List;

import controller.generic.ManageControllerAbstract;
import dao.DaoFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Contribution;
import model.User;
import model.enumration.Role;

public class UserManageController extends ManageControllerAbstract<User>{


    @FXML
    private TextField searchFirstName;

    @FXML
    private TextField searchLastName;

    @FXML
    private TextField searchPhone;

    @FXML
    private ComboBox<?> searchRole;

    @FXML
    private TableColumn<User, String> columnContribute;

    @FXML
    private TableColumn<User, String> columnFirstName;

    @FXML
    private TableColumn<User, String> columnLastName;

    @FXML
    private TableColumn<User, String> columnLoan;

    @FXML
    private TableColumn<User, String> columnPhone;

    @FXML
    private TableColumn<User, Role> columnRole;


	@Override
	public void setDao() throws SQLException {
		dao = DaoFactory.getUserDao();
	}

	@Override
	protected List<User> search() {
		return null;
	}

	@Override
	protected void initTable() {
		columnFirstName.setCellValueFactory(new PropertyValueFactory<User, String>("firstname"));
		columnLastName.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
		columnPhone.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
		columnRole.setCellValueFactory(new PropertyValueFactory<User, Role>("role"));

//		columnContribute.setCellValueFactory(new PropertyValueFactory<User, Integer>("row"));
//		columnLoan.setCellValueFactory(new PropertyValueFactory<User, String>("matricule"));
		
//		columnStatut.setCellValueFactory(new PropertyValueFactory<Employee, Boolean>("payed"));
		/*columnStatut.setCellFactory(new Callback<TableColumn<Employee, Boolean>,TableCell<Employee, Boolean>> (){

			@Override
			public TableCell<Employee, Boolean> call(TableColumn<Employee, Boolean> arg0) {
				return new TableCell<Employee,Boolean>(){
					@Override
					protected void updateItem(Boolean item, boolean empty) {
						super.updateItem(item, empty);
						if(item!=null) {
							if(!item) {
								setText("Non payé");
								setTextFill(Color.RED);
							}else {
								setText("Payé");
								setTextFill(Color.GREEN);
							}
						}
					}
				};
			}
		});*/
	}

}
	