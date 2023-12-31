package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.Dao;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;

public abstract class AbstractManageController<T> implements Initializable, InterfaceManageController<T>{

	protected Dao<T> dao;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			getTableView().setItems(FXCollections.observableArrayList(dao.getAll(15)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
