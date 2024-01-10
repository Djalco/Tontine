package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.generic.ManageControllerAbstract;
import dao.DaoFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
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

	}


}
	