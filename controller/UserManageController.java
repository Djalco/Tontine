package controller;

import java.sql.SQLException;
import java.util.List;

import controller.generic.ManageControllerAbstract;
import dao.DaoFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.User;

public class UserManageController extends ManageControllerAbstract<User>{

    @FXML
    private Button btnAdd;

    @FXML
    private HBox pagination;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchFirstName;

    @FXML
    private TextField searchLastName;

    @FXML
    private ComboBox<?> searchNumResult;

    @FXML
    private ComboBox<?> searchOrder;

    @FXML
    private TextField searchPhone;

    @FXML
    private ComboBox<?> searchRole;

    @FXML
    private TableView<User> table;

    @FXML
    private Text titleTable;

	@Override
	public Button getSearchBtn() {
		return null;
	}

	@Override
	public Button getAdd() {
		return btnAdd;
	}

	@Override
	public ComboBox<?> getOrder() {
		return searchOrder;
	}

	@Override
	public ComboBox<?> getResult() {
		return searchNumResult;
	}

	@Override
	public Text getTitleTable() {
		return titleTable;
	}

	@Override
	public TableView<User> getTableView() {
		return table;
	}

	@Override
	public HBox getPagination() {
		return pagination;
	}

	@Override
	public List<User> search() {
		return null;
	}

	@Override
	public void setDao() throws SQLException {
		dao = DaoFactory.getUserDao();
	}

}
	