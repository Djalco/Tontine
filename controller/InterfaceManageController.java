package controller;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public interface InterfaceManageController<T> {

	public Button getSearch();

	public Button getAdd();
	
	public ComboBox<?> getOrder();
	
	public ComboBox<?> getResult();
	
	public Text getTitleTable();
	
	public TableView<T> getTableView();
	
	public HBox getPagination();
	
	public List<T> search();
}
