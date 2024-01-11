package controller.generic;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import controller.PrincipalController;
import controller.enumeration.State;
import dao.Dao;
import dao.LoanDao;
import exception.EntityNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.User;
import util.Validator;

public abstract class EntityControllerAbstract<T> implements Initializable, EntityControllerInterface<T>{

	protected Dao<T> dao;

	protected Map<VBox, Validator> validates;

	private VBox page;

	private PrincipalController principal;

	private ManageControllerAbstract<T> manageController;

	protected State state;

	protected boolean isUpdate = false;

	protected T entity; 

	@FXML
	protected Button backBtn;

	@FXML
	protected Button cancelBtn;

	@FXML
	protected Button mainBtn;

	@FXML
	protected Button moreBtn;

	@Override
	public Button getBackBtn() {
		return backBtn;
	}

	@Override
	public Button getMainBtn() {
		return mainBtn;
	}

	@Override
	public Button getCancelBtn() {
		return cancelBtn;
	}

	@Override
	public Button getMoreBtn() {
		return moreBtn;
	}

	protected abstract void setField() throws Exception;

	protected abstract void clearField() throws Exception;

	protected abstract void disableField(boolean disable);

	protected abstract void buildEntity() throws Exception;

	protected abstract void setDao() throws SQLException;

	protected void setTextField(VBox vbox, String text) throws Exception {
		getTexteField(vbox).setText(text);
	}

	protected TextField getTexteField(VBox vbox) throws Exception {
		try {
			return (TextField)((HBox)vbox.getChildren().get(1)).getChildren().get(1);
		}catch(Exception e) {

		}
		throw new Exception("Le composant est invalide");
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	protected<D> ComboBox<D> getComboBox(VBox vbox) throws Exception {
		try {
			return (ComboBox<D>)((HBox)vbox.getChildren().get(1)).getChildren().get(1);
		}catch(Exception e) {

		}
		throw new Exception("Le composant est invalide");
	}

	@SuppressWarnings("unchecked")
	protected Spinner<Integer> getSpinner(VBox vbox) throws Exception {
		try {
			return (Spinner<Integer>)((HBox)vbox.getChildren().get(1)).getChildren().get(1);
		}catch(Exception e) {

		}
		throw new Exception("Le composant est invalide");
	}

	protected void setDisable(VBox vbox, boolean disable) {
		vbox.setDisable(disable);
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	protected void removeEntity() {
		this.entity = null;
	}

	@Override
	public void setState(State state) throws Exception {
		this.state = state;
		init();
	}

	@Override
	public void closeUpdate() {
		isUpdate = false;
	}

	@Override
	public void setPage(VBox page) {
		this.page = page;
	}

	@Override
	public void setController(PrincipalController principal, ManageControllerAbstract<T> manageController) {
		this.principal = principal;
		this.manageController = manageController;
	}

	protected void setValidatorTextField(VBox vbox, Validator validator) throws Exception {
		TextField field = getTexteField(vbox);
		field.setOnKeyReleased(e->{
			if(vbox.getChildren().size() == 3)
				vbox.getChildren().remove(2);

			Text text = new Text();
			boolean error = false;
			text.getStyleClass().add("text-error");
			HBox hbox = (HBox) vbox.getChildren().get(1);
			hbox.getStyleClass().remove("input-box-error");
			if(field.getText().isEmpty()) {
				text.setText(validator.getEmptyMsg());
				error = true;
			}else if(!validator.isValidRegex(field.getText())){
				text.setText(validator.getregexMsg());
				error = true;
			}else if(!validator.isValidlength(field.getText())){
				text.setText(validator.getLengthMsg());
				error = true;
			}
			if(error) {
				vbox.getChildren().add(text);
				hbox.getStyleClass().add("input-box-error");
			}

			try {
				mainBtn.setDisable(!isValidForm());
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		validates.put(vbox, validator);
	}

	protected void setValidatorPassword(VBox vbox_1, Validator validator_1,VBox vbox_2, Validator validator_2) throws Exception {
		TextField field_1 = getTexteField(vbox_1);
		TextField field_2 = getTexteField(vbox_2);
		field_1.setOnKeyReleased(e->{
			if(vbox_1.getChildren().size() == 3)
				vbox_1.getChildren().remove(2);

			Text text_1 = new Text();
			boolean error = false;
			text_1.getStyleClass().add("text-error");
			HBox hbox_1 = (HBox) vbox_1.getChildren().get(1);
			HBox hbox_2 = (HBox) vbox_2.getChildren().get(1);
			hbox_1.getStyleClass().remove("input-box-error");
			hbox_2.getStyleClass().remove("input-box-error");
			if(field_1.getText().isEmpty()) {
				text_1.setText(validator_1.getEmptyMsg());
				error = true;
			}else if(!validator_1.isValidRegex(field_1.getText())){
				text_1.setText(validator_1.getregexMsg());
				error = true;
			}else if(!validator_1.isValidlength(field_1.getText())){
				text_1.setText(validator_1.getLengthMsg());
				error = true;
			}

			if(vbox_2.getChildren().size() == 3) 
				vbox_2.getChildren().remove(2);

			if(!field_1.getText().equals(field_2.getText())) {

				Text text_2 = new Text();
				text_2.getStyleClass().add("text-error");
				hbox_2.getStyleClass().add("input-box-error");
				text_2.setText(validator_2.getEmptyMsg());
				vbox_2.getChildren().add(text_2);

			}
			if(error) {
				vbox_1.getChildren().add(text_1);
				hbox_1.getStyleClass().add("input-box-error");
			}

			try {
				mainBtn.setDisable(!isValidForm());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		field_2.setOnKeyReleased(e->{
			HBox hbox = (HBox) vbox_2.getChildren().get(1);
			hbox.getStyleClass().remove("input-box-error");

			if(vbox_2.getChildren().size() == 3)
				vbox_2.getChildren().remove(2);

			if(!field_1.getText().equals(field_2.getText())) {

				Text text_2 = new Text();
				text_2.getStyleClass().add("text-error");
				text_2.setText(validator_2.getEmptyMsg());
				vbox_2.getChildren().add(text_2);
				hbox.getStyleClass().add("input-box-error");
				mainBtn.setDisable(true);
			}

			try {
				mainBtn.setDisable(!isValidForm());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		validates.put(vbox_1, validator_1);
		validates.put(vbox_2, validator_2);
	}

	public void init() throws Exception {
		removeError();
		if(state == State.ADD) {
			if(!((HBox) cancelBtn.getParent()).getChildren().contains(mainBtn))
				((HBox) cancelBtn.getParent()).getChildren().add(0,mainBtn);
			mainBtn.setText("Ajouter");
			cancelBtn.setText("Annuler");
			clearField();
			disableField(false);
			moreBtn.setVisible(false);
			mainBtn.setDisable(true);
		}
		if(state == State.MODIFY) {
			if(!((HBox) cancelBtn.getParent()).getChildren().contains(mainBtn))
				((HBox) cancelBtn.getParent()).getChildren().add(0,mainBtn);
			mainBtn.setText("Modifier");
			cancelBtn.setText("Annuler");
			setField();
			disableField(false);
			moreBtn.setVisible(false);
//			mainBtn.setDisable(true);
		}
		if(state == State.DETAIL) {
			((HBox) cancelBtn.getParent()).getChildren().remove(mainBtn);
			cancelBtn.setText("Retour");
			setField();
			disableField(true);
			if(dao instanceof LoanDao)
			moreBtn.setVisible(false);
			else
				moreBtn.setVisible(true);
		}

	}

	private boolean isValidForm() throws Exception {
		boolean valid = true;
		for(Map.Entry<VBox, Validator> entry: validates.entrySet()) {
			String text = getTexteField(entry.getKey()).getText();
			Validator validator = entry.getValue();
			valid = (validator.isValid(text))?valid:false;
		}
		return valid;
	}

	@Override
	public void removeError() {
		for(Map.Entry<VBox, Validator> entry: validates.entrySet()) {
			VBox vbox = entry.getKey();
			HBox hbox = (HBox) vbox.getChildren().get(1);
			hbox.getStyleClass().remove("input-box-error");
			if(vbox.getChildren().size() == 3)
				vbox.getChildren().remove(2);

		}

	}

	protected abstract void initComponent() throws Exception;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		validates = new HashMap<VBox, Validator>();
		try {
			setDao();
			initComponent();
			mainBtn.setOnAction(e->{
				try {
					buildEntity();
					if(state == State.ADD) {
						manageController.addObj(dao.create(entity));
						principal.backPane(page, manageController, state, "Utilisateur ajouté avec succès");
						mainBtn.setDisable(true);
					}
					else if(state == State.MODIFY) {
						manageController.replaceObj(dao.update(entity));
						principal.backPane(page, manageController, state, "Utilisateur modifié avec succès");
					}
					isUpdate = true;
					backBtn.fire();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (EntityNotFoundException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public T getEntity() {
		return entity;
	}

}
