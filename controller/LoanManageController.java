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
import model.Loan;
import model.Session;
import model.User;

public class LoanManageController extends ManageControllerAbstract<Loan>{

    @FXML
    private Button btnAdd;

    @FXML
    private TableColumn<Loan, Integer> columnAmount;

    @FXML
    private TableColumn<Loan, Session> columnLoan;

    @FXML
    private TableColumn<Loan, User> columnMember;

    @FXML
    private TableColumn<Loan, Session> columnRemaining;

    @FXML
    private TableColumn<Loan, Text> columnStatus;

    @FXML
    private HBox pagination;

    @FXML
    private Button searchBtn;

    @FXML
    private ComboBox<?> searchContribute;

    @FXML
    private ComboBox<?> searchLoan;

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
		dao = DaoFactory.getLoanDao();
	}

	@Override
	protected List<User> search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void initTable() {
		columnMember.setCellValueFactory(new PropertyValueFactory<Loan, User>("user"));
		columnAmount.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("amount"));
		columnLoan.setCellValueFactory(new PropertyValueFactory<Loan, Session>("session"));
		columnRemaining.setCellValueFactory(new PropertyValueFactory<Loan, Session>("sessionSold"));
		columnStatus.setCellValueFactory(new PropertyValueFactory<Loan, Text>("statusColor"));
	}

}
