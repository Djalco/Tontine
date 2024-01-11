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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Session;
import model.User;

public class SessionManageController extends ManageControllerAbstract<Session>{


	@FXML
	private TableColumn<Session, String> columnCotisation;

	@FXML
	private TableColumn<Session, String> columnLoan;

	@FXML
	private TableColumn<Session, Text> columnStatisContribute;

	@FXML
	private TableColumn<Session, Text> columnStatusLoan;

	@FXML
	private TableColumn<Session, Integer> columnNum;
	
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
	private Text titleTable;

	@Override
	protected void setDao() throws SQLException {
		dao = DaoFactory.getSessionDao();

	}

	@Override
	protected List<User> search() {
		return null;
	}

	@Override
	protected void initTable() {
		columnCotisation.setCellValueFactory(new PropertyValueFactory<Session, String>("cotisation"));
		columnLoan.setCellValueFactory(new PropertyValueFactory<Session, String>("loan"));
		columnNum.setCellValueFactory(new PropertyValueFactory<Session, Integer>("numSession"));
		columnStatisContribute.setCellValueFactory(new PropertyValueFactory<Session, Text>("statusColorContribute"));
		columnStatusLoan.setCellValueFactory(new PropertyValueFactory<Session, Text>("statusColorLoan"));
	}


}