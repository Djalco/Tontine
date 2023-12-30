package controller;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public interface InterfaceManageController<T> {

	public HBox getHBoxTitle();
	
	public Button getSetting();

	public Button getLogOut();

	public Button getSearch();

	public Button getAdd();
	
	public ComboBox<?> getOrder();
	
	public ComboBox<?> getResult();
	
	public Text getTitleTable();
	
	public TableView<T> getTableView();
	
	public HBox getPagination();
	
	public List<T> search();
}
