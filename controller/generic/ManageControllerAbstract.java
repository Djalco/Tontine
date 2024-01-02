package controller.generic;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.Dao;
import dao.DaoFactory;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public abstract class ManageControllerAbstract<T> implements Initializable, ManageControllerInterface<T>{

	protected Dao<T> dao;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			setDao();
			getTableView().setItems(FXCollections.observableArrayList(dao.getAll(15)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
