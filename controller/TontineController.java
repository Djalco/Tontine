package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.SettingDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.Validator;
import util.Validator.RegexType;

public class TontineController implements Initializable{

	@FXML
	private TextField amount_cotisation;

	@FXML
	private ChoiceBox<String> dateType;

	@FXML
	private ChoiceBox<String> frequency;

	@FXML
	private TextField infractionAmount;

	@FXML
	private ChoiceBox<String> infractionType;

	@FXML
	private TextField loanAmount;

	@FXML
	private ChoiceBox<String> loanType;

	@FXML
	private Button mainBtn;

	@FXML
	private Spinner<Integer> nbreSession;

	@FXML
	private TextField tontineAmount;
	
	@FXML
	private DatePicker dateStart;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
		valueFactory.setValue(0);

		nbreSession.setValueFactory(valueFactory);

		infractionType.getItems().addAll("Pourcentage","Increment");
		loanType.getItems().addAll("Pourcentage","Increment");

		dateType.getItems().addAll("Hebdomadaire","Mensuel");

		frequency.getItems().addAll("Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche");

		infractionType.getSelectionModel().selectFirst();
		loanType.getSelectionModel().selectFirst();
		dateType.getSelectionModel().selectFirst();
		frequency.getSelectionModel().selectFirst();

		dateType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> {
			frequency.getItems().clear();
			if(newValue.equals("Hebdomadaire")) 
				frequency.getItems().addAll("Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche");
			else
				for(int i = 0; i < 32; i++)
					frequency.getItems().add(i+"");
			frequency.getSelectionModel().selectFirst();
		});
		setValidatorTextField(loanAmount);
		setValidatorTextField(infractionAmount);
		setValidatorTextField(amount_cotisation);
		setValidatorTextField(tontineAmount);
		
		dateStart.setValue(LocalDate.now());
		mainBtn.setOnAction(e->{
			try {
				SettingDao.initSetting(nbreSession.getValue(), 
						frequency.getSelectionModel().getSelectedIndex(),  
						dateType.getSelectionModel().getSelectedIndex(), 
						Integer.valueOf(tontineAmount.getText()), 
						loanType.getSelectionModel().getSelectedIndex(),
						Integer.valueOf(loanAmount.getText()), 
						infractionType.getSelectionModel().getSelectedIndex(), 
						Integer.valueOf(infractionAmount.getText()), 
						Integer.valueOf(amount_cotisation.getText()),
						dateStart.getValue()) ;
				
				((Stage)frequency.getScene().getWindow()).close();
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/view/principal.fxml"));
				Scene scene = new Scene(root,1200,800);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

	public void setValidatorTextField(TextField textField){
		textField.textProperty().addListener((observable, oldValue, newValue)-> {
			if(textField.getText().isEmpty()) {
				textField.setText("0");
			}else{
				try {
					Integer.valueOf(newValue);
				}catch(Exception a) {
					textField.setText(oldValue);
				}
			}
		});
		textField.setText("0");
	}

}
