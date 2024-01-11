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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Sanction;
import model.Session;
import model.User;

public class SanctionManageController extends ManageControllerAbstract<Sanction>{

    @FXML
    private Button btnAdd;

    @FXML
    private TableColumn<Sanction, Integer> columnAmount;

    @FXML
    private TableColumn<Sanction, Session> columnSanction;

    @FXML
    private TableColumn<Sanction, User> columnMember;

    @FXML
    private TableColumn<Sanction, Text> columnStatus;

    @FXML
    private HBox pagination;

    @FXML
    private Button searchBtn;

    @FXML
    private ComboBox<?> searchContribute;

    @FXML
    private ComboBox<?> searchSanction;

    @FXML
    private ComboBox<?> searchNum;

    @FXML
    private ComboBox<?> searchNumResult;

    @FXML
    private ComboBox<?> searchOrder;

    @FXML
    private Text titleTable;

	@Override
	protected void setDao() throws SQLException {
		dao = DaoFactory.getSanctionDao();
	}

	@Override
	protected List<User> search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initTable() {
		columnMember.setCellValueFactory(new PropertyValueFactory<Sanction, User>("user"));
		columnAmount.setCellValueFactory(new PropertyValueFactory<Sanction, Integer>("amount"));
		columnSanction.setCellValueFactory(new PropertyValueFactory<Sanction, Session>("sessionStart"));
		columnStatus.setCellValueFactory(new PropertyValueFactory<Sanction, Text>("statusColor"));
	}

}
